@file:Suppress("NonAsciiCharacters")

package org.example.lehmall.order.app.service

import org.assertj.core.api.Assertions.assertThat
import org.example.lehmall.order.app.repository.OrderRepository
import org.example.lehmall.order.app.service.common.ClockProvider
import org.example.lehmall.order.domain.OrderEntityFixture
import org.example.lehmall.order.domain.event.OrderCanceledEvent
import org.example.lehmall.testsupport.SpringBootTestSupport
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.event.ApplicationEvents

class OrderCancelServiceTest @Autowired constructor(
    private val sut: OrderCancelService,
    private val applicationEvents: ApplicationEvents,
    private val clockProvider: ClockProvider,
    private val orderRepository: OrderRepository,
) : SpringBootTestSupport() {

    @Test
    fun `id가 주어지면 주문을 취소하고 OrderCanceledEvent를 발행한다 - MockBean 방식`() {
        // Arrange
        val order = orderRepository.save(OrderEntityFixture.of())

        // Act
        val actual = sut.cancel(order.id)

        // Assert
        assertThat(order.canceledAt).isEqualTo(clockProvider.now())
        assertThat(actual.id).isEqualTo(order.id)

        // 주문취소 이벤트 발행 검증
        val events = applicationEvents.stream(OrderCanceledEvent::class.java).toList()
        assertThat(events).hasSize(1)
        assertThat(events[0].orderId).isEqualTo(order.id)
    }

}

// 방법 2: @RecordApplicationEvents 애노테이션 사용 (Spring Boot 2.3+)
/*
import org.springframework.test.context.event.ApplicationEvents
import org.springframework.test.context.event.RecordApplicationEvents

@RecordApplicationEvents
class OrderCancelServiceTestV2 @Autowired constructor(
    private val sut: OrderCancelService,
    private val clockProvider: ClockProvider,
    private val orderRepository: OrderRepository,
    private val events: ApplicationEvents,  // 자동 주입됨
) : SpringBootTestSupport() {

    @Test
    fun `id가 주어지면 주문을 취소하고 OrderCanceledEvent를 발행한다`() {
        // Arrange
        val order = orderRepository.save(OrderEntityFixture.of())

        // Act
        val actual = sut.cancel(order.id)

        // Assert
        assertThat(order.canceledAt).isEqualTo(clockProvider.now())
        assertThat(actual.id).isEqualTo(order.id)

        // Verify event publication
        val publishedEvents = events.stream(OrderCanceledEvent::class.java).toList()
        assertThat(publishedEvents).hasSize(1)
        assertThat(publishedEvents[0].orderId).isEqualTo(order.id)
    }
}
*/

// 방법 3: @SpyBean 사용 (실제 이벤트도 전파되면서 검증 가능)
/*
import org.springframework.boot.test.mock.mockito.SpyBean

class OrderCancelServiceTestV3 @Autowired constructor(
    private val sut: OrderCancelService,
    private val clockProvider: ClockProvider,
    private val orderRepository: OrderRepository,
    @SpyBean private val eventPublisher: ApplicationEventPublisher,
) : SpringBootTestSupport() {

    @Test
    fun `id가 주어지면 주문을 취소하고 OrderCanceledEvent를 발행한다`() {
        // Arrange
        val order = orderRepository.save(OrderEntityFixture.of())

        // Act
        val actual = sut.cancel(order.id)

        // Assert
        assertThat(order.canceledAt).isEqualTo(clockProvider.now())
        assertThat(actual.id).isEqualTo(order.id)

        // Verify event publication
        val eventCaptor = ArgumentCaptor.forClass(OrderCanceledEvent::class.java)
        verify(eventPublisher).publishEvent(eventCaptor.capture())
        assertThat(eventCaptor.value.orderId).isEqualTo(order.id)
    }
}
*/
