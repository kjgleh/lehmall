package org.example.lehmall.order.service

import org.example.lehmall.order.repository.OrderRepository
import org.example.lehmall.order.service.dto.OrderCancelResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCancelService(
    private val orderRepository: OrderRepository,
) {

    fun cancel(id: Long): OrderCancelResponse {
        TODO("Not yet implemented")
    }
}
