package me.sup2is.service;

import me.sup2is.domain.Member;
import me.sup2is.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(false)
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void save_all_failed_when_username_is_invalid(){
        //given
        List<Member> members = Arrays.asList(Member.createMember("#choi", 28),
                Member.createMember("#woo", 30),
                Member.createMember("park", 35));

        //when
        try {
            memberService.saveAll(members);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //then
        List<Member> all = memberRepository.findAll();
        assertEquals(0, all.size());
        assertTrue(all.isEmpty());
    }
}