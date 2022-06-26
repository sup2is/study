package me.sup2is.reactiveexam.ch02

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.SynchronousSink

fun main(args: Array<String>) {

    println("\n###  Flux.flatmap()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .flatMap {
            Flux.just(*it.name.toList().toTypedArray())
        }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.flatMapSequential()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .flatMapSequential {
            Flux.just(*it.name.toList().toTypedArray())
        }
        .subscribe { println("subscribe: $it") }

    println("\n###  Flux.handle()\n")

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).log()
        .handle { person: Person, synchronousSink: SynchronousSink<String> ->
            if (person.age == 29) {
                synchronousSink.next(person.name)
            } else {
                synchronousSink.complete()
            }
        }
        .subscribe { println("subscribe: $it") }

    println("\n###  Mono.flatMapMany()\n")

    Mono.just(
        Person(name = "choi", age = 29)
    ).log()
        .flatMapMany {
            Flux.just(*it.name.toList().toTypedArray())
        }
        .subscribe { println("subscribe: $it") }
}
