package org.example.lehmall.config

import java.time.Clock
import java.time.LocalDateTime
import java.time.ZoneId
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary

@TestConfiguration
class TestClockConfig {

    @Bean
    @Primary
    fun fixedClock(): Clock {
        val fixedTime = LocalDateTime.of(2024, 3, 15, 10, 0)

        return Clock.fixed(
            fixedTime.atZone(ZoneId.systemDefault()).toInstant(),
            ZoneId.systemDefault(),
        )
    }
}
