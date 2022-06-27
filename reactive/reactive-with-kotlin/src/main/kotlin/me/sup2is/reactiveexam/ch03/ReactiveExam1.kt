package me.sup2is.reactiveexam.ch03

import me.sup2is.reactiveexam.Person
import reactor.core.publisher.Flux

fun main(args: Array<String>) {

    Flux.just(
        Person(name = "choi", age = 29),
        Person(name = "woo", age = 31)
    ).doOnNext { println("doOnNext: $it") }
        .doOnComplete { println("doOnComplete!") }
        .doOnError {
            println("doOnError: $it")
        }
        .doOnCancel { println("doOnCancel!") }
        .doFirst { println("doFirst!") }
        .doOnSubscribe { println("doOnSubscribe: $it") }
        .doOnRequest { println("doOnRequest: $it") }
        .doOnTerminate() { println("doOnTerminate!") }
        .doAfterTerminate { println("doAfterTerminate!") }
        .doOnEach { println("doOnEach: $it") }
        .doFinally { println("doFinally: $it") }
        .subscribe { println("subscribe: $it") }
}
