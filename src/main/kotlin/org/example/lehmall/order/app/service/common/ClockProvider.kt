package org.example.lehmall.order.app.service.common

import java.time.Clock
import java.time.LocalDate
import java.time.LocalDateTime
import org.springframework.stereotype.Component

@Component
class ClockProvider(private val clock: Clock) {

    fun now(): LocalDateTime = LocalDateTime.now(clock)
    fun today(): LocalDate = LocalDate.now(clock)
}
