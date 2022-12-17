package me.sup2is.spring6example.client

import me.sup2is.spring6example.client.dto.MemberRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange
import reactor.core.publisher.Mono

interface MemberClient {

    @GetExchange("/member/{memberId}")
    fun getMember(@PathVariable memberId: String): Mono<String>

    @PostExchange("/member")
    fun saveMember(@RequestBody member: MemberRequest): Mono<MemberRequest>
}