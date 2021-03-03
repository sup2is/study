package me.sup2is.service;

import me.sup2is.domain.Member;
import me.sup2is.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void save_all_when_data_format_exception() throws DataFormatException {
        //given

        List<Member> members = Arrays.asList(Member.createMember("#choi", 28),
                Member.createMember("#woo", 30),
                Member.createMember("park", 35));

        //when
        memberService.saveAll(members);

        //then
        List<Member> all = memberRepository.findAll();
        assertEquals(0, all.size());
        assertTrue(all.isEmpty());

    }
}