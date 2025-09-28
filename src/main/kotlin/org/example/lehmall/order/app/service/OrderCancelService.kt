package org.example.lehmall.order.app.service

import org.example.lehmall.common.RepositoryExtensions.findByIdOrThrow
import org.example.lehmall.order.app.repository.OrderRepository
import org.example.lehmall.order.app.service.common.ClockProvider
import org.example.lehmall.order.app.service.provided.OrderCanceler
import org.example.lehmall.order.app.service.provided.dto.OrderCancelResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCancelService(
    private val clockProvider: ClockProvider,
    private val orderRepository: OrderRepository,
) : OrderCanceler {

    override fun cancel(id: Long): OrderCancelResponse {
        val order = orderRepository.findByIdOrThrow(id)

        order.cancel(clockProvider.now())

        orderRepository.save(order)

        return OrderCancelResponse(order.id)
    }
}
