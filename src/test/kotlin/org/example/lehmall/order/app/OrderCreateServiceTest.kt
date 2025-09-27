@file:Suppress("NonAsciiCharacters")

package org.example.lehmall.order.app

import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.example.lehmall.order.app.service.OrderCreateService
import org.example.lehmall.order.domain.dto.member.MemberDtoFixture
import org.example.lehmall.order.domain.dto.order.OrderCreateRequestFixture
import org.example.lehmall.order.domain.dto.order.OrderCreateRequestFixture.OrderItemDtoFixture
import org.example.lehmall.order.repository.OrderRepository
import org.example.lehmall.order.repository.RepositoryExtensions.findByIdOrThrow
import org.example.lehmall.testsupport.SpringBootTestSupport
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class OrderCreateServiceTest @Autowired constructor(
    private val sut: OrderCreateService,
    private val orderRepository: OrderRepository,
) : SpringBootTestSupport() {

    @Test
    fun `주문 생성 요청이 주어지면 주문을 생성한다`() {
        // Arrange
        val request = OrderCreateRequestFixture.of(
            items = listOf(
                OrderItemDtoFixture.of(),
                OrderItemDtoFixture.of(),
            )
        )

        val member = MemberDtoFixture.of(request.memberId)
        every {
            memberFindService.find(request.memberId)
        } returns member

        // Act
        val actual = sut.create(request)

        // Assert
        val order = orderRepository.findByIdOrThrow(actual.id)
        assertThat(order.id).isGreaterThan(0)
        assertThat(order.memberId).isEqualTo(request.memberId)
        assertThat(order.items).hasSize(2)
    }

}
