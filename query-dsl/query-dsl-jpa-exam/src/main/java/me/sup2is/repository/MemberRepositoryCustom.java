package me.sup2is.repository;

import me.sup2is.domain.Member;

public interface MemberRepositoryCustom {
    Member findByName(String name);
}
