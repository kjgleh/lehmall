package org.example.lehmall.order.app.service.provided

import org.example.lehmall.order.app.service.provided.dto.OrderFindResponse

interface OrderFinder {

    fun find(id: Long): OrderFindResponse
}
