package me.sup2is.reactiveexam.ch05

import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    println("\n### Mono.onErrorReturn()\n")

    Mono.error<RuntimeException>(IllegalStateException())
        .onErrorReturn(
            RuntimeException()
        )
        .log()
        .doOnError { println("doOnError: $it") }
        .subscribe()

    Thread.sleep(100)

    println("\n### Mono.onErrorResume()\n")

    Mono.error<RuntimeException>(IllegalStateException())
        .onErrorResume {
            Mono.just(RuntimeException())
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
