package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import java.util.stream.Collectors

fun main(args: Array<String>) {

    println("\n###  Flux.collectList()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .collectList()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.collectSortedList()\n")

    Flux.just(
        'b', 'd', 'c', 'a'
    ).log()
        .collectSortedList()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.collectMap()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .collectMap { it.name }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.collectMultiMap()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "choi", age = 31),
        Person(name = "woo", age = 34)
    ).log()
        .collectMultimap { it.name }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.collect()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .collect(Collectors.toList())
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.count()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .count()
        .subscribe { println("subscribe: $it") }
}
