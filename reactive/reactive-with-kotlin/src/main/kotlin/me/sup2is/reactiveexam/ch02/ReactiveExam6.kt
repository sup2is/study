package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux

fun main(args: Array<String>) {

    println("\n###  Flux.all()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .all { it.name == "choi" }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.any()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .any { it.name == "choi" }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.hasElements()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .hasElements()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.hasElement()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .map { it.name }
        .hasElement("choi")
        .subscribe { println("subscribe: $it") }
}
