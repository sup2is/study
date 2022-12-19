package me.sup2is.spring6example.controller

import me.sup2is.spring6example.client.dto.MemberRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

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