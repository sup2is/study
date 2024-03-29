package me.sup2is.spring6example.client

import me.sup2is.spring6example.client.dto.MemberRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClientResponseException
import reactor.kotlin.test.test

// 일단 서버 먼저 올려야됨..~
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Test
    fun `get 테스트`() {
        // given
        val memberId = "choi"

        memberRepository.getMember(memberId)
            .test()
            .expectNext("hello $memberId")
            .verifyComplete()
    }

    @Test
    fun `post 테스트`() {
        // given
        val memberRequest = MemberRequest("choi", 30)

        memberRepository.saveMember(memberRequest)
            .test()
            .expectNext(memberRequest)
            .verifyComplete()
    }


    @Test
    fun `error handling 테스트`() {
        // given
        val memberRequest = MemberRequest("choi", 10)

        memberRepository.saveMember(memberRequest)
            .test()
            .expectError(WebClientResponseException::class.java)
            .verify()
    }
}