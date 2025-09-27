package org.example.lehmall.order.domain.event

data class OrderCreatedEvent(
    val orderId: Long,
) : DomainEvent
