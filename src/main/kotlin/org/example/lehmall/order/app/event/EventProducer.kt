package org.example.lehmall.order.app.event

import org.example.lehmall.order.domain.event.DomainEvent

interface EventProducer {
    fun produce(event: DomainEvent)
}
