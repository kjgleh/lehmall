@file:Suppress("NonAsciiCharacters")

package org.example.lehmall.order.app.service.provided

import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.example.lehmall.common.RepositoryExtensions.findByIdOrThrow
import org.example.lehmall.order.app.repository.OrderRepository
import org.example.lehmall.order.domain.dto.member.MemberDtoFixture
import org.example.lehmall.order.domain.dto.order.OrderCreateRequestFixture
import org.example.lehmall.testsupport.SpringBootTestSupport
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class OrderReceiverTest @Autowired constructor(
    private val sut: OrderReceiver,
    private val orderRepository: OrderRepository,
) : SpringBootTestSupport() {

    @Test
    fun `주문 생성 요청이 주어지면 주문을 생성한다`() {
        // Arrange
        val request = OrderCreateRequestFixture.of(
            items = listOf(
                OrderCreateRequestFixture.OrderItemDtoFixture.of(),
                OrderCreateRequestFixture.OrderItemDtoFixture.of(),
            )
        )

        val member = MemberDtoFixture.of(request.memberId)
        every {
            memberFinder.find(request.memberId)
        } returns member

        // Act
        val actual = sut.receive(request)

        // Assert
        val order = orderRepository.findByIdOrThrow(actual.id)
        assertThat(order.id).isGreaterThan(0)
        assertThat(order.memberId).isEqualTo(request.memberId)
        assertThat(order.items).hasSize(2)
    }

}
