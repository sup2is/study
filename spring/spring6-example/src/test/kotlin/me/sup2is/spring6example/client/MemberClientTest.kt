package me.sup2is.spring6example.client

import me.sup2is.spring6example.client.dto.MemberRequest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import reactor.kotlin.test.test

// 일단 서버 먼저 올려야됨..~
@SpringBootTest
class MemberClientTest {

    lateinit var memberClient: MemberClient
    lateinit var webClient: WebClient

    @BeforeEach
    fun setup() {
        webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build()

        val webClientAdapter = WebClientAdapter.forClient(webClient)

        val httpServiceProxyFactory = HttpServiceProxyFactory.builder()
            .clientAdapter(webClientAdapter)
            .build()

        memberClient = httpServiceProxyFactory.createClient(MemberClient::class.java)
    }

    @Test
    fun `get 테스트`() {
        // given
        val memberId = "choi"

        memberClient.getMember(memberId)
            .test()
            .expectNext("hello $memberId")
            .verifyComplete()
    }

    @Test
    fun `post 테스트`() {
        // given
        val memberRequest = MemberRequest("choi", 30)

        memberClient.saveMember(memberRequest)
            .test()
            .expectNext(memberRequest)
            .verifyComplete()
    }

}