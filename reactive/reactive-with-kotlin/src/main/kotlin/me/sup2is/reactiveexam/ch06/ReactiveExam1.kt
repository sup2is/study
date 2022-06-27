package me.sup2is.reactiveexam.ch06

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import java.time.Duration

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    )

    println("\n### Flux.elapsed()\n")

    group1.timed()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.timestamp()\n")

    group1.timed()
        .timestamp()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.delayElements()\n")

    Thread.sleep(2000)

    group1.delayElements(Duration.ofSeconds(1))
        .log()
        .subscribe { println("subscribe: $it") }

    Thread.sleep(2000)
}
