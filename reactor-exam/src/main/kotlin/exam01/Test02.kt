package exam01

import org.reactivestreams.Subscription
import reactor.core.publisher.BaseSubscriber
import reactor.core.publisher.Flux

fun main() {

    Flux.range(1, 10)
        .doOnRequest { r: Long -> println("request of $r") }
        .subscribe(object : BaseSubscriber<Int>() {
            override fun hookOnSubscribe(subscription: Subscription) {
                request(1)
            }

            override fun hookOnNext(integer: Int) {
                println("Cancelling after having received $integer")
                cancel()
            }
        })
}