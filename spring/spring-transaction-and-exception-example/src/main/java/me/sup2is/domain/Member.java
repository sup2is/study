package me.sup2is.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private int age;

    public static Member createMember(String name, int age) {
        Member member = new Member();
        member.name = name;
        member.age = age;
        return member;
    }

}
