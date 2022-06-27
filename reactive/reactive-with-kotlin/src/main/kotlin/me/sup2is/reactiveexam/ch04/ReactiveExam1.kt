package me.sup2is.reactiveexam.ch04

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    println("\n### Flux.filter()\n")

    group1.filter {
        it.age >= 30
    }.log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.filterWhen()\n")

    group1.filterWhen {
        Mono.just(it.age >= 30)
    }.log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.ofType()\n")

    group1.ofType(
        Person::class.java
    )
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.distinct()\n")

    Flux.just(
        1, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8, 9, 9
    )
        .log()
        .distinct()
        .collectList()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.distinctUntilChanged()\n")

    Flux.just(
        1, 2, 1, 2, 2, 2, 3, 1, 2
    )
        .log()
        .distinctUntilChanged()
        .collectList()
        .subscribe { println("subscribe: $it") }
}
