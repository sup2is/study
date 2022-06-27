
package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    )

    val choi = Mono.just(Person(name = "choi", age = 29))

    val woo = Mono.just(Person(name = "woo", age = 31))

    println("\n###  Mono.ignoreElements()\n")

    Mono.ignoreElements(choi)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.then()\n")

    choi.then()
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.then()\n")

    choi.then(woo)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.thenEmpty()\n")

    choi.thenEmpty(Mono.empty())
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.thenReturn()\n")

    choi.thenReturn(Person(name = "woo", age = 31))
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.thenMany()\n")

    choi.thenMany(group1)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.delayUntil()\n")

    choi.delayUntil { woo }
        .log()
        .subscribe { println("subscribe: $it") }
}
