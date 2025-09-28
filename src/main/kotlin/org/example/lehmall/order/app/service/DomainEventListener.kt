package org.example.lehmall.order.app.service

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.lehmall.order.app.service.required.EventProducer
import org.example.lehmall.order.domain.event.OrderCanceledEvent
import org.example.lehmall.order.domain.event.OrderReceivedEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

private val logger = KotlinLogging.logger {}

@Component
class DomainEventListener(
    private val eventProducer: EventProducer,
) {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    fun handleOrderCreatedEvent(event: OrderReceivedEvent) {
        logger.info { "주문접수 이벤트 수신: $event" }
        eventProducer.produce(event)
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    fun handleOrderCanceledEvent(event: OrderCanceledEvent) {
        logger.info { "주문취소 이벤트 수신: $event" }
        eventProducer.produce(event)
    }
}
