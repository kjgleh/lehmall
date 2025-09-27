package org.example.lehmall

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class LehmallApplication

fun main(args: Array<String>) {
    runApplication<LehmallApplication>(*args)
}
