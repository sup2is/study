package me.sup2is.spring6example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WebApplication

fun main() {
    SpringApplication.run(WebApplication::class.java)
}