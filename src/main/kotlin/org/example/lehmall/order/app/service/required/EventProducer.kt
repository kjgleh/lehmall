package org.example.lehmall.order.app.service.required

import org.example.lehmall.order.domain.event.DomainEvent

interface EventProducer {

    fun produce(event: DomainEvent)
}
