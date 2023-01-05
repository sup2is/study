package exam01

import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink

fun main() {

    Flux.generate(
        { 0 },
        { state, sink ->
            sink.next("3 x $state = ${state.times(3)}")
            if (state == 10) sink.complete()
            state + 1
        }
    ) {
        println("handle... $it")
    }.subscribe {
        println(it)
    }

}