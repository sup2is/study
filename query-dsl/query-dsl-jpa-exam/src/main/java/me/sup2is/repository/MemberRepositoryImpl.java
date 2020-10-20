package me.sup2is.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.sup2is.domain.Member;
import me.sup2is.domain.QMember;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Member findByName(String name) {
        return jpaQueryFactory.selectFrom(QMember.member)
                .where(QMember.member.name.eq("choi"))
                .fetchOne();
    }
}
