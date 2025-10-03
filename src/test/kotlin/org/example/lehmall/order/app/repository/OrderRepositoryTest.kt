@file:Suppress("NonAsciiCharacters")

package org.example.lehmall.order.app.repository

import org.example.lehmall.order.domain.OrderEntityFixture
import org.example.lehmall.testsupport.DataJpaTestSupport
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class OrderRepositoryTest @Autowired constructor(
    private val orderRepository: OrderRepository,
) : DataJpaTestSupport() {

    @Test
    fun `주문을 생성한다`() {
        // Arrange

        // Act
        orderRepository.save(OrderEntityFixture.of())

        // Assert

    }

}
