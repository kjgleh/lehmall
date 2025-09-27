package org.example.lehmall.order.app.event

import io.github.oshai.kotlinlogging.KotlinLogging
import org.example.lehmall.order.domain.event.OrderCreatedEvent
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

private val logger = KotlinLogging.logger {}

@Component
class OrderEventListener(
    private val eventProducer: EventProducer,
) {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Async
    fun handleOrderCreatedEvent(event: OrderCreatedEvent) {
        logger.info { "주문생성 이벤트 수신: $event" }
        eventProducer.produce(event)
    }
}
