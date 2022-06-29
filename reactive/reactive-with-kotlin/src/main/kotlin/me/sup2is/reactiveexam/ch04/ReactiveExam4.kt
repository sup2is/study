package me.sup2is.reactiveexam.ch04

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import java.time.Duration

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    println("\n### Flux.sample()\n")

    group1.sample(Duration.ofMillis(500))
        .log()
        .subscribe { println("subscribe: $it") }

    Thread.sleep(2000)

    println("\n### Flux.sampleFirst()\n")

    group1.sampleFirst(Duration.ofMillis(500))
        .log()
        .subscribe { println("subscribe: $it") }

    Thread.sleep(2000)

    println("\n### Flux.single()\n")

    Flux.just(1)
        .single()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.singleOrEmpty()\n")

    Flux.just(1)
        .singleOrEmpty()
        .log()
        .subscribe { println("subscribe: $it") }
}
