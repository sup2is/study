package me.sup2is.repository;

import me.sup2is.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void find_by_name() {
        //given
        Member member = Member.createMember("choi", "서울시 강남구");
        memberRepository.save(member);

        //when
        Member findMember = memberRepository.findByName("choi");

        //then
        assertEquals(member, findMember);
    }

}