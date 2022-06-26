package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    println("\n###  Flux.startWith()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .startWith(Person(name = "yoon", age = 30))
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.concatWith()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .concatWith(Mono.just(Person(name = "yoon", age = 30)))
        .subscribe { println("subscribe: $it") }
}
