package org.example.lehmall.order.app.service

import java.time.LocalDateTime
import org.example.lehmall.order.app.service.dto.OrderCancelResponse
import org.example.lehmall.order.repository.OrderRepository
import org.example.lehmall.order.repository.RepositoryExtensions.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCancelService(
    private val orderRepository: OrderRepository,
) {

    fun cancel(id: Long): OrderCancelResponse {
        val order = orderRepository.findByIdOrThrow(id)

        order.cancel(LocalDateTime.now())

        orderRepository.save(order)

        return OrderCancelResponse(order.id)
    }
}
