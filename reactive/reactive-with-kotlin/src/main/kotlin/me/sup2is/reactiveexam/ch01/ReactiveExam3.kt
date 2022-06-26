package me.sup2is.reactiveexam.ch01

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import java.util.stream.Stream

fun main(args: Array<String>) {

    println("\n###  Flux.fromArray()\n")

    val personArray = arrayOf(Person(name = "choi", age = 29), Person(name = "woo", age = 31))

    Flux.fromArray(personArray)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.fromIterable()\n")

    val personList = listOf(Person(name = "choi", age = 29), Person(name = "woo", age = 31))

    Flux.fromIterable(personList)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.range()\n")

    Flux.range(1, 5)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.fromStream()\n")

    val stream = Stream.of(Person(name = "choi", age = 29))

    Flux.fromStream(stream)
        .log()
        .subscribe { println("subscribe: $it") }
}
