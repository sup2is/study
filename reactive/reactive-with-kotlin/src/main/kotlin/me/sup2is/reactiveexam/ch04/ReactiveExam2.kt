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

    println("\n### Flux.take()\n")

    group1.take(2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.take()\n")

    group1.take(Duration.ofSeconds(1))
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.next()\n")

    group1.next()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.takeLast()\n")

    group1.takeLast(2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.takeUntil()\n")

    group1.takeUntil {
        it.age == 30
    }
        .log()
        .collectList()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.takeWhile()\n")

    group1.takeWhile {
        it.age <= 30
    }
        .log()
        .collectList()
        .subscribe { println("subscribe: $it") }
}
