package me.sup2is.reactiveexam.ch05

import reactor.core.publisher.Mono
import reactor.util.retry.Retry
import java.time.Duration

fun main(args: Array<String>) {

    println("\n### Mono.retry()\n")

    Mono.error<RuntimeException>(IllegalStateException())
        .log()
        .retry(1)
        .subscribe()

    Thread.sleep(100)

    println("\n### Mono.retryWhen()\n")

    Mono.error<RuntimeException>(IllegalStateException())
        .log()
        .retryWhen(
            Retry.fixedDelay(2, Duration.ofMillis(500))
        )
        .subscribe()

    Thread.sleep(2000)
}
