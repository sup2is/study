package me.sup2is.reactiveexam.ch01

import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink

fun main(args: Array<String>) {

    println("\n###  Flux.generate()\n")

    val callable = {
        arrayOf(0, 1)
    }

    var emitCounter = 0
    val biFunction: (Array<Int>, SynchronousSink<Int>) -> Array<Int> = { ints: Array<Int>, synchronousSink: SynchronousSink<Int> ->
        synchronousSink.next(ints[0])
        emitCounter ++
        if (emitCounter >= 10) {
            synchronousSink.complete()
        }

        val temp = ints[0]
        ints[0] = ints[1]
        ints[1] = ints[1] + temp
        ints
    }

    Flux.generate(
        callable, biFunction
    ).log()
        .subscribe()
}
