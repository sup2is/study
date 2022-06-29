package me.sup2is.reactiveexam.ch06

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import java.time.Duration

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    )

    println("\n### Flux.timed()\n")

    group1.timed()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.timed().elapsed()\n")

    group1.timed()
        .elapsed()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.timed().timestamp()\n")

    group1.timed()
        .timestamp()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.elapsed()\n") // legacy

    group1.elapsed()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.timestamp()\n") // legacy

    group1.timestamp()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.delayElements()\n")

    group1.delayElements(Duration.ofMillis(500))
        .log()
        .subscribe { println("subscribe: $it") }

    Thread.sleep(2000)
}
