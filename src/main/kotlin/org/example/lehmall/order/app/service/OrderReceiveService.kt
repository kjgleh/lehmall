package org.example.lehmall.order.app.service

import org.example.lehmall.order.app.repository.OrderRepository
import org.example.lehmall.order.app.service.provided.OrderReceiver
import org.example.lehmall.order.app.service.provided.dto.OrderReceiveResponse
import org.example.lehmall.order.app.service.required.MemberFinder
import org.example.lehmall.order.domain.OrderEntity
import org.example.lehmall.order.domain.dto.order.OrderReceiveRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderReceiveService(
    private val memberFinder: MemberFinder,
    private val orderRepository: OrderRepository,
) : OrderReceiver {

    override fun receive(request: OrderReceiveRequest): OrderReceiveResponse {
        val member = memberFinder.find(request.memberId)
        val order = orderRepository.save(
            OrderEntity.of(request, member)
        )

        return OrderReceiveResponse.of(order)
    }
}
