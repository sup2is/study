package me.sup2is.reactiveexam.ch05

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

    println("\n### Mono.onErrorReturn()\n")

    group1.single()
        .onErrorReturn(
            Person(name = "error", age = 999)
        )
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

    println("\n### Mono.onErrorResume()\n")

    group1.single()
        .onErrorResume {
            Mono.just(Person(name = "error", age = 999))
        }
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

    println("\n### Mono.onErrorMap()\n")

    Mono.error<RuntimeException>(IllegalStateException())
        .onErrorMap {
            RuntimeException(it)
        }
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

    println("\n### Mono.doFinally()\n")

    Mono.error<RuntimeException>(IllegalStateException())
        .onErrorMap {
            RuntimeException(it)
        }
        .doFinally { println("doFinally: $it") }
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

}
