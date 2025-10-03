package org.example.lehmall.order.app.service.provided

import org.example.lehmall.order.app.service.provided.dto.OrderReceiveResponse
import org.example.lehmall.order.domain.dto.OrderReceiveRequest

interface OrderReceiver {

    fun receive(request: OrderReceiveRequest): OrderReceiveResponse
}
