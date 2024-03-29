
package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    )

    val group2 = Flux.just(
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    val choi = Mono.just(Person(name = "choi", age = 29))

    val woo = Mono.just(Person(name = "woo", age = 31))

    println("\n###  Mono.and()\n")

    choi.and(woo)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.when()\n")

    Mono.`when`(choi, woo)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.firstWithSignal()\n")

    Mono.firstWithSignal(choi, woo)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.firstWithSignal()\n")

    Flux.firstWithSignal(group1, group2)
        .log()
        .subscribe { println("subscribe: $it") }
}
