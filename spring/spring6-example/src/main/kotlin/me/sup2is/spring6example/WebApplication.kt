package me.sup2is.spring6example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication
@ConfigurationPropertiesScan("me.sup2is.spring6example")
class WebApplication

fun main() {
    SpringApplication.run(WebApplication::class.java)
}