package org.example.lehmall.order.domain.event

data class OrderCanceledEvent(
    val orderId: Long,
) : DomainEvent
