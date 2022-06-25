package me.sup2is.reactiveexam.ch01

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    println("\n###  Mono.fromSupplier()\n")

    val personSupplier: () -> Person = { Person(name = "choi", age = 29) }

    Mono.fromSupplier(personSupplier)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.defer()\n")

    val monoSupplier: () -> Mono<Person> = { Mono.just(Person(name = "choi", age = 29)) }

    Mono.defer(monoSupplier)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.defer()\n")

    val fluxSupplier: () -> Flux<Person> = {
        Flux.just(
            Person(name = "choi", age = 29),
            Person(name = "woo", age = 31)
        )
    }

    Flux.defer(fluxSupplier)
        .log()
        .subscribe { println("subscribe: $it") }
}
