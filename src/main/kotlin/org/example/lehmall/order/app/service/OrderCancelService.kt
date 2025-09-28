package org.example.lehmall.order.app.service

import org.example.lehmall.order.app.service.common.ClockProvider
import org.example.lehmall.order.app.service.dto.OrderCancelResponse
import org.example.lehmall.order.repository.OrderRepository
import org.example.lehmall.order.repository.RepositoryExtensions.findByIdOrThrow
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCancelService(
    private val clockProvider: ClockProvider,
    private val orderRepository: OrderRepository,
) {

    fun cancel(id: Long): OrderCancelResponse {
        val order = orderRepository.findByIdOrThrow(id)

        order.cancel(clockProvider.now())

        orderRepository.save(order)

        return OrderCancelResponse(order.id)
    }
}
