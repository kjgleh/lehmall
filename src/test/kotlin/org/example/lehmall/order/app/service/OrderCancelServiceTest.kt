@file:Suppress("NonAsciiCharacters")

package org.example.lehmall.order.app.service

import org.assertj.core.api.Assertions.assertThat
import org.example.lehmall.order.app.repository.OrderRepository
import org.example.lehmall.order.app.service.common.ClockProvider
import org.example.lehmall.order.domain.OrderEntityFixture
import org.example.lehmall.testsupport.SpringBootTestSupport
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class OrderCancelServiceTest @Autowired constructor(
    private val sut: OrderCancelService,
    private val clockProvider: ClockProvider,
    private val orderRepository: OrderRepository,
) : SpringBootTestSupport() {

    @Test
    fun `id가 주어지면 주문을 취소한다`() {
        // Arrange
        val order = orderRepository.save(OrderEntityFixture.of())

        // Act
        val actual = sut.cancel(order.id)

        // Assert
        assertThat(order.canceledAt).isEqualTo(clockProvider.now())
        assertThat(actual.id).isEqualTo(order.id)
    }

}
