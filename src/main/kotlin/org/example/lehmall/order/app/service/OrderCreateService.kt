package org.example.lehmall.order.app.service

import org.example.lehmall.order.app.service.dto.OrderCreateResponse
import org.example.lehmall.order.domain.OrderEntity
import org.example.lehmall.order.domain.dto.order.OrderCreateRequest
import org.example.lehmall.order.repository.OrderRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class OrderCreateService(
    private val memberFindService: MemberFindService,
    private val orderRepository: OrderRepository,
) {

    fun create(request: OrderCreateRequest): OrderCreateResponse {
        val member = memberFindService.find(request.memberId)
        val order = orderRepository.save(
            OrderEntity.of(request, member)
        )

        return OrderCreateResponse.of(order)
    }
}
