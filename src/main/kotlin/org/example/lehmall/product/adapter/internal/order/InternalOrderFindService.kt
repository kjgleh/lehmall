package org.example.lehmall.product.adapter.internal.order

import org.example.lehmall.product.app.service.required.OrderFinder
import org.example.lehmall.product.app.service.required.dto.OrderDto
import org.springframework.stereotype.Service

@Service
class InternalOrderFindService() : OrderFinder {

    override fun find(orderId: Long): OrderDto {
        TODO("Not yet implemented")
    }
}
