package org.example.lehmall.product.app.service.required

import org.example.lehmall.product.app.service.required.dto.OrderDto

interface OrderFinder {

    fun find(orderId: Long): OrderDto
}
