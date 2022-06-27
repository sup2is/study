
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

    println("\n###  Mono.defaultIfEmpty()\n")

    Mono.empty<Person>()
        .defaultIfEmpty(Person(name = "choi", age = 29))
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.defaultIfEmpty()\n")

    Flux.empty<Person>()
        .defaultIfEmpty(Person(name = "woo", age = 31))
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.switchIfEmpty()\n")

    Mono.empty<Person>()
        .switchIfEmpty(choi)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.switchIfEmpty()\n")

    Flux.empty<Person>()
        .switchIfEmpty(group1)
        .log()
        .subscribe { println("subscribe: $it") }
}
