package org.example.lehmall.order.adapter.internal.event

import org.example.lehmall.order.app.event.EventProducer
import org.example.lehmall.order.domain.event.DomainEvent
import org.springframework.stereotype.Component

@Component
class RabbitMqEventProducer : EventProducer {

    override fun produce(event: DomainEvent) {
        TODO("Not yet implemented")
    }
}
