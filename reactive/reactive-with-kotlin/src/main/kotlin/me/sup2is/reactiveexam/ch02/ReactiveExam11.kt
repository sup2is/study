
package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import java.time.Duration

fun main(args: Array<String>) {

    val group1 = Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    )

    println("\n###  Flux.repeat()\n")

    group1.repeat(2)
        .log()
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.interval()\n")

    Flux.interval(Duration.ofSeconds(1))
        .flatMap {
            group1
        }
        .repeat(2)
        .log()
        .subscribe { println("subscribe: $it") }

    Thread.sleep(3000)
}
