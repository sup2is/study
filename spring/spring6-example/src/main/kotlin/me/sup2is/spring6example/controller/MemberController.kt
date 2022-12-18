package me.sup2is.spring6example.controller

import me.sup2is.spring6example.client.dto.MemberRequest
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.lang.IllegalArgumentException

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

    @PostMapping
    fun save(@RequestBody memberRequest: MemberRequest): ResponseEntity<Mono<MemberRequest>> {
        return ResponseEntity(memberRequest.toMono()
            .doOnNext{
                if(it.age < 20) {
                    throw IllegalArgumentException()
                }
            }
            .doOnSuccess {
                print("save $it")
            }, HttpStatus.CREATED)

    }

}