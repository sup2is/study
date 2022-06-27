package me.sup2is.reactiveexam.ch07

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    println("\n### Flux.buffer()\n")

    group1.buffer(2) // return Mono<MutableList<T>>
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.bufferUntil()\n")

    group1.bufferUntil { it.age >= 30 } // return Mono<MutableList<T>>
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.bufferWhile()\n")

    group1.bufferWhile { it.age >= 30 } // return Mono<MutableList<T>>
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n### Flux.groupBy()\n")

    group1.groupBy { it.age }
        .flatMap {
            println("key: ${it.key()}")
            it
        }
        .log()
        .subscribe { println("subscribe: $it") }
}
