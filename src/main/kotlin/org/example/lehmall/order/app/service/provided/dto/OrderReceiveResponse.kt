package org.example.lehmall.order.app.service.provided.dto

import org.example.lehmall.order.domain.OrderEntity

data class OrderReceiveResponse(
    val id: Long,
) {

    companion object {
        fun of(order: OrderEntity): OrderReceiveResponse {
            return OrderReceiveResponse(
                id = order.id,
            )
        }
    }
}
