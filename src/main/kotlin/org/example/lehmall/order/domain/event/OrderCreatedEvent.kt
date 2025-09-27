package org.example.lehmall.order.domain.event

data class OrderCreatedEvent(
    val orderId: Long,
    val orderNo: String,
    val memberId: Long,
    val memberName: String,
    val totalAmount: Int,
    val itemCount: Int
) : DomainEvent()