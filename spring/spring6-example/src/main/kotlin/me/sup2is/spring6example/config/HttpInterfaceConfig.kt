package me.sup2is.spring6example.config

import me.sup2is.spring6example.client.MemberRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class HttpInterfaceConfig {

    @Bean
    fun memberRepository(webClient: WebClient): MemberRepository {
        val memberClient = webClient.mutate()
            .baseUrl("http://localhost:8080")
            .build()

        val webClientAdapter = WebClientAdapter.forClient(memberClient)

        val httpServiceProxyFactory = HttpServiceProxyFactory.builder()
            .clientAdapter(webClientAdapter)
            .build()

         return httpServiceProxyFactory.createClient(MemberRepository::class.java)
    }
}