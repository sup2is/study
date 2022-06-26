
package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

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

    println("\n###  Mono.or()\n")

    choi.or(woo)
        .log()
        .subscribe { println("subscribe: $it") }
}
