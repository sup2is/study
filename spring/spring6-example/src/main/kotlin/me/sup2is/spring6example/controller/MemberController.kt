package me.sup2is.spring6example.controller

import me.sup2is.spring6example.client.dto.MemberRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/member")
class MemberController {

    @GetMapping("/{memberId}")
    fun get(@PathVariable memberId: String): Mono<String> {
        return Mono.just("hello $memberId")
            .doOnSuccess {
                print(it)
            }
    }

    @PostMapping("/")
    fun save(@RequestBody memberRequest: MemberRequest): Mono<MemberRequest> {
        return Mono.just(memberRequest)
            .doOnSuccess {
                print("save $it")
            }
    }
}