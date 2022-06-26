package me.sup2is.reactiveexam.ch01

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    println("\n###  Mono.just()\n")

    Mono.just(Person(name = "choi", age = 29))
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.just()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.justOrEmpty()\n")

    val persion: Person? = null

    Mono.justOrEmpty(persion)
        .log()
        .subscribe()
}
