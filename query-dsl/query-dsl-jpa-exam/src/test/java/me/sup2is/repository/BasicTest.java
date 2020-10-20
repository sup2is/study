package me.sup2is.repository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import me.sup2is.domain.Member;
import me.sup2is.domain.QMember;
import me.sup2is.domain.QTeam;
import me.sup2is.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class BasicTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void find_one() {
        //given
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        memberRepository.save(Member.createMember("choi", "서울시 강남구"));

        //when
        Member findMember = jpaQueryFactory.selectFrom(QMember.member)
                .where(QMember.member.name.eq("choi"))
                .fetchOne();

        //then
        assertNotNull(findMember);
    }


    @Test
    public void find_all() {
        //given
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        memberRepository.save(Member.createMember("choi", "서울시 강남구"));
        memberRepository.save(Member.createMember("woo", "서울시 강남구"));
        memberRepository.save(Member.createMember("sup2is", "서울시 서초구"));
        memberRepository.save(Member.createMember("john", "서울시 강동구"));

        //when
        List<Member> fetch = jpaQueryFactory.selectFrom(QMember.member)
                .where(QMember.member.name.eq("choi"),
                        QMember.member.address.contains("강남구"))
                .fetch();

        //then
        assertEquals(1, fetch.size());
    }

    @Test
    public void join() {
        //given
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        Member choi = Member.createMember("choi", "서울시 강남구");
        Member woo = Member.createMember("woo", "서울시 강남구");
        memberRepository.save(choi);
        memberRepository.save(woo);

        Team teamA = Team.createTeam("A team");
        Team teamB = Team.createTeam("B team");
        teamRepository.save(teamA);
        teamRepository.save(teamB);
        teamA.addMember(choi);
        teamA.addMember(woo);

        //when
        List<?> fetch = jpaQueryFactory.from(QMember.member)
                .join(QMember.member.team, QTeam.team)
                .where(QMember.member.address.eq("서울시 강남구"))
                .fetch();

        //then
        assertEquals(2, fetch.size());
    }


    @Test
    public void ordering() {
        //given
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        Member choi = Member.createMember("choi", "서울시 강남구");
        Member woo = Member.createMember("woo", "서울시 강남구");
        Member kim = Member.createMember("kim", "서울시 서초구");
        memberRepository.save(choi);
        memberRepository.save(woo);
        memberRepository.save(kim);

        //when
        List<?> fetch = jpaQueryFactory.from(QMember.member)
                .orderBy(QMember.member.name.asc())
                .fetch();

        //then
        assertEquals(3, fetch.size());
        assertEquals(choi, fetch.get(0));
    }

    @Test
    public void sub_query() {
        //given
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);
        Member choi = Member.createMember("choi", "서울시 강남구");
        Member woo = Member.createMember("woo", "서울시 강남구");
        Member kim = Member.createMember("kim", "서울시 서초구");
        memberRepository.save(choi);
        memberRepository.save(woo);
        memberRepository.save(kim);

        //when
        List<?> fetch = jpaQueryFactory.from(QMember.member)
                .where(QMember.member.name.in(
                        JPAExpressions.select(QMember.member.name)
                        .from(QMember.member)
                ))
                .fetch();


        //then
        assertEquals(3, fetch.size());
    }

}