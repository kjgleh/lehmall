package org.example.lehmall.order.service.dto

import org.example.lehmall.order.domain.OrderEntity

data class OrderCancelResponse(
    val id: Long,
) {

    companion object {
        fun of(order: OrderEntity): OrderCancelResponse {
            return OrderCancelResponse(
                id = order.id,
            )
        }
    }
}
