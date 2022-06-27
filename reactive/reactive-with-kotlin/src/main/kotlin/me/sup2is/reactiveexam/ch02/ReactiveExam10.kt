
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

    println("\n###  Flux.switchMap()\n")

    group1.switchMap {
        Mono.just(it.name)
    }.log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.switchOnNext()\n")

    Flux.switchOnNext(Flux.just(group1, group2))
        .log()
        .subscribe { println("subscribe: $it") }
}
