package org.example.lehmall.order.app.service.dto

import org.example.lehmall.order.domain.OrderEntity

data class OrderCreateResponse(
    val id: Long,
) {

    companion object {
        fun of(order: OrderEntity): OrderCreateResponse {
            return OrderCreateResponse(
                id = order.id,
            )
        }
    }
}
