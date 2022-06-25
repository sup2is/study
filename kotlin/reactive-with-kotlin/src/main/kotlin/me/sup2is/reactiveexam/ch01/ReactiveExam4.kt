package me.sup2is.reactiveexam.ch01

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    println("\n###  Mono.empty()\n")

    Mono.empty<Any>()
        .log()
        .defaultIfEmpty("DEFAULT")
        .subscribe()

    println("\n###  Flux.empty()\n")

    Flux.empty<Any>()
        .log()
        .defaultIfEmpty("DEFAULT")
        .subscribe()

    println("\n###  Mono.error()\n")

    Mono.error<Any>(IllegalAccessException())
        .log()
        .subscribe()

    Thread.sleep(100)

    println("\n###  Flux.error()\n")

    Flux.error<Any>(IllegalAccessException())
        .log()
        .subscribe()

    Thread.sleep(100)

    println("\n###  Mono.never()\n")

    Mono.never<Any>()
        .log()
        .defaultIfEmpty("DEFAULT")
        .subscribe()

    println("\n###  Flux.never()\n")

    Flux.never<Any>()
        .log()
        .defaultIfEmpty("DEFAULT")
        .subscribe()
}
