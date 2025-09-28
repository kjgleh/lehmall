package org.example.lehmall.order.domain.event

data class OrderReceivedEvent(
    val orderId: Long,
) : DomainEvent
