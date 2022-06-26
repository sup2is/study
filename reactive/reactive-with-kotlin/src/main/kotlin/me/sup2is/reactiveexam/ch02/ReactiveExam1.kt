package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    println("\n###  Mono.map()\n")

    Mono.just(Person(name = "choi", age = 29))
        .log()
        .map { it.age }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.map()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .map { it.name }
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.cast()\n")

    Mono.just(Person(name = "choi", age = 29))
        .log()
        .cast(Any::class.java)
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.cast()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .cast(Any::class.java)
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.index()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .index()
        .subscribe { println("index: ${it.t1}, data: ${it.t2}") }
}
