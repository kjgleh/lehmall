package org.example.lehmall.order.app.service.provided

import org.example.lehmall.order.app.service.provided.dto.OrderCancelResponse

interface OrderCanceler {

    fun cancel(id: Long): OrderCancelResponse
}
