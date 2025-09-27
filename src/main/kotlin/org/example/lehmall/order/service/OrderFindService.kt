package org.example.lehmall.order.service

import org.example.lehmall.order.repository.OrderRepository
import org.example.lehmall.order.service.dto.OrderFindResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderFindService(
    private val orderRepository: OrderRepository,
) {

    fun find(id: Long): OrderFindResponse {
        val order = orderRepository.findByIdOrNull(id)
            ?: error("Order with id $id not found")

        return OrderFindResponse.of(order)
    }
}
