package me.sup2is.reactiveexam.ch05

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31),
        Person(name = "yoon", age = 30),
        Person(name = "hwang", age = 30)
    )

    val choi = Mono.just(Person(name = "choi", age = 29))

    println("\n### Flux.error()\n")

    Flux.error<RuntimeException>(RuntimeException())
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

    println("\n### Flux.concat()\n")

    Flux.concat(
        Flux.error<RuntimeException>(RuntimeException())
    )
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

    println("\n### Mono.then()\n")

    choi.then(
        Mono.error<RuntimeException>(RuntimeException())
    )
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

    println("\n### Flux.timeout()\n")

    group1.timeout(Duration.ofSeconds(1))
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)
}
