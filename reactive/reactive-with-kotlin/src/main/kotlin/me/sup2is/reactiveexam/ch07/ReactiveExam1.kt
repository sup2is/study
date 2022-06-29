package me.sup2is.reactiveexam.ch07

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import java.time.Duration

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    println("\n### Flux.window()\n")

    group1.window(2)
        .flatMap {
            println("slice")
            it
        }
        .log()
        .subscribe()

    println("\n### Flux.windowTimeout()\n")

    group1.windowTimeout(2, Duration.ofMillis(500))
        .flatMap {
            println("slice")
            it
        }
        .log()
        .subscribe()

    println("\n### Flux.windowUntil()\n")

    group1.windowUntil { it.age >= 30 }
        .flatMap {
            println("slice")
            it
        }
        .log()
        .subscribe()

    println("\n### Flux.windowWhile()\n")

    group1.windowWhile { it.age >= 30 }
        .flatMap {
            println("slice")
            it
        }
        .log()
        .subscribe()
}
