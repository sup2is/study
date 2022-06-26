package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    )

    println("\n###  Flux.zip()\n")

    val biFunction: (Person, Int) -> String = {
            person, int ->
        "index: $int = ${person.name}"
    }

    Flux.zip(group1, Flux.just(1, 2, 3, 4, 5), biFunction)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.zipWith()\n")

    group1.zipWith(Flux.just(1, 2, 3, 4, 5), biFunction)
        .log()
        .subscribe { println("subscribe: $it") }

    val biFunction2: (Person, Person) -> String = {
            person1, person2 ->
        "${person1.name} and ${person2.name}"
    }

    println("\n###  Mono.zip()\n")

    val choi = Mono.just(Person(name = "choi", age = 29))

    val woo = Mono.just(Person(name = "woo", age = 31))

    Mono.zip(choi, woo, biFunction2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.zipWith()\n")

    choi.zipWith(woo, biFunction2)
        .log()
        .subscribe { println("subscribe: $it") }
}
