package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    )

    val group2 = Flux.just(
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    println("\n###  Flux.concat()\n")

    Flux.concat(group1, group2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.concatWith()\n")

    group1.concatWith(group2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.concatDelayError()\n")

    Flux.concatDelayError(group1, group2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.mergeSequential()\n")

    Flux.mergeSequential(group1, group2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.merge()\n")

    Flux.merge(group1)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.mergeWith()\n")

    group1.mergeWith(group2)
        .log()
        .subscribe { println("subscribe: $it") }
}
