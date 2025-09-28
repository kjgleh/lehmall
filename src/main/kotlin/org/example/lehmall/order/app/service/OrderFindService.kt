package org.example.lehmall.order.app.service

import org.example.lehmall.common.RepositoryExtensions.findByIdOrThrow
import org.example.lehmall.order.app.repository.OrderRepository
import org.example.lehmall.order.app.service.provided.OrderFinder
import org.example.lehmall.order.app.service.provided.dto.OrderFindResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrderFindService(
    private val orderRepository: OrderRepository,
) : OrderFinder {

    override fun find(id: Long): OrderFindResponse {
        val order = orderRepository.findByIdOrThrow(id)

        return OrderFindResponse.of(order)
    }
}
