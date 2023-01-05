package exam01

import reactor.core.publisher.Flux
import java.time.Duration

fun main() {

//    Flux.range(1, 100)
//        .log()
//        .subscribe { println(it) }

    Flux.range(1, 100)
        .log()
        .delaySequence(Duration.ofMillis(100))
        .limitRate(10)
        .subscribe(System.out::println);

    Thread.sleep(10000)

}