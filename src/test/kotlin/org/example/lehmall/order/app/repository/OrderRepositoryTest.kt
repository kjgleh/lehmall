@file:Suppress("NonAsciiCharacters")

package org.example.lehmall.order.app.repository

import org.example.lehmall.order.domain.OrderEntityFixture
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class OrderRepositoryTest @Autowired constructor(
    private val orderRepository: OrderRepository,
) {

    @Test
    fun `주문을 생성한다`() {
        // Arrange

        // Act
        orderRepository.save(OrderEntityFixture.of())

        // Assert

    }

}
