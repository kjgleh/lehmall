package org.example.lehmall.order.app.service.provided.dto

import org.example.lehmall.order.domain.OrderEntity

data class OrderFindResponse(
    val id: Long,
) {

    companion object {
        fun of(order: OrderEntity): OrderFindResponse {
            return OrderFindResponse(id = order.id)
        }
    }
}
