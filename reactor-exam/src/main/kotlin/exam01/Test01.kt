package exam01

import reactor.core.Disposables
import reactor.core.publisher.Flux
import java.time.Duration

fun main() {

    val disposable = Flux.range(0, 10)
        .delayElements(Duration.ofMillis(200))
        .subscribe { println(it) }

    val disposable2 = Flux.range(10, 20)
        .delayElements(Duration.ofMillis(200))
        .subscribe { println(it) }

    val disposable3 = Flux.range(20, 30)
        .delayElements(Duration.ofMillis(200))
        .subscribe { println(it) }

    val composite = Disposables.composite()

    composite.add(disposable)
    composite.add(disposable2)
    composite.add(disposable3)

    println(composite.isDisposed)

    Thread.sleep(1000)

    composite.dispose()

    Thread.sleep(3000)

    println(composite.isDisposed)
}