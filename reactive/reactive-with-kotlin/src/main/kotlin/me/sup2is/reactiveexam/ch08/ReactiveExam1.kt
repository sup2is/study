package me.sup2is.reactiveexam.ch08

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    println("\n### Flux.blockFirst()\n")

    val blockFirst = group1.blockFirst()

    println("blockFirst: $blockFirst")

    println("\n### Flux.blockLast()\n")

    val blockLast = group1.blockLast()
    println("blockLast: $blockLast")

    println("\n### Flux.toIterable()\n")

    group1.toIterable()
        .forEach { println("iterable: $it") }

    println("\n### Flux.toStream()\n")

    group1.toStream()
        .map { it.name }
        .forEach { println("toStream: $it") }

    println("\n### Mono.block()\n")

    val block = Mono.just(Person(name = "choi", age = 29)).block()
    println("block: $block")

    println("\n### Mono.toFuture()\n")

    val toFuture = Mono.just(Person(name = "choi", age = 29)).toFuture().get()
    println("toFuture: $toFuture")
}
