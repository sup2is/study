package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux

fun main(args: Array<String>) {

    println("\n###  Flux.reduce()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .map { it.age }
        .reduce { age1, age2 ->
            age1 + age2
        }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.scan()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .map { it.age }
        .scan { age1, age2 ->
            age1 + age2
        }
        .subscribe { println("subscribe: $it") }
}
