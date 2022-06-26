package me.sup2is.reactiveexam.ch01

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

fun main(args: Array<String>) {

    println("\n###  Mono.using()\n")

    val callable = {
        Person(name = "choi", age = 29)
    }

    val function: (Person) -> Mono<Person> = {
        Mono.just(Person(name = it.name, age = it.age))
    }

    val consumer: (Person) -> Unit = { println(it) }

    Mono.using(
        callable, function, consumer
    ).log()
        .subscribe()

    println("\n###  Flux.using()\n")

    val callable2 = {
        listOf(Person(name = "choi", age = 29), Person(name = "woo", age = 31))
    }

    val function2: (List<Person>) -> Flux<Person> = {
        Flux.fromIterable(it)
    }

    val consumer2: (List<Person>) -> Unit = { println(it) }

    Flux.using(
        callable2, function2, consumer2
    ).log()
        .subscribe()
}
