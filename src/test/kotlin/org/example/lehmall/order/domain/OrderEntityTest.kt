@file:Suppress("NonAsciiCharacters")

package org.example.lehmall.order.domain

import java.time.LocalDateTime
import kotlin.random.Random
import org.assertj.core.api.Assertions.assertThat
import org.example.lehmall.order.domain.event.OrderCanceledEvent
import org.junit.jupiter.api.Test

class OrderEntityTest {

    @Test
    fun `주문을 취소하고 이벤트를 발행한다`() {
        // Arrange
        val sut = OrderEntityFixture.of(id = Random.nextLong(1, 100))
        val canceledAt = LocalDateTime.of(2025, 9, 28, 16, 0)

        // Act
        sut.cancel(canceledAt)

        // Assert
        assertThat(sut.canceledAt).isEqualTo(canceledAt)

        val events = sut.domainEventList()
        assertThat(events).hasSize(1)
        val payload = events[0] as OrderCanceledEvent
        assertThat(payload.orderId).isEqualTo(sut.id)
    }

}


