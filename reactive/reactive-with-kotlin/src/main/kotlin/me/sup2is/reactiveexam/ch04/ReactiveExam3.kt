package me.sup2is.reactiveexam.ch04

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    println("\n### Flux.elementAt()\n")

    group1.elementAt(2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.last()\n")

    group1.last()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.skip()\n")

    group1.skip(2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.skipLast()\n")

    group1.skipLast(1)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.skipUntil()\n")

    group1.skipUntil {
        it.age == 30
    }
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.skipWhile()\n")

    group1.skipWhile {
        it.age != 30
    }
        .log()
        .subscribe { println("subscribe: $it") }
}
