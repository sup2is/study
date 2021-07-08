package me.sup2is.lazyconnectiondatasourceproxy.domain;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor

class MemberServiceTest {

    final MemberService memberService;

    @Test
    void test() {
        //given
        final Member build = Member.builder().build();

        //when
        memberService.create(build);
        //then
    }


}