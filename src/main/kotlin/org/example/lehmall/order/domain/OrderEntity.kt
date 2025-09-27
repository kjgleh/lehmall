package org.example.lehmall.order.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime
import java.util.*
import org.example.lehmall.order.domain.dto.member.MemberDto
import org.example.lehmall.order.domain.dto.order.OrderCreateRequest
import org.example.lehmall.order.domain.event.OrderCreatedEvent

@Entity(name = "orders")
class OrderEntity(
    orderNo: String,
    memberId: Long,
    memberName: String,
) : AbstractEntity<OrderEntity>() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
        protected set

    var orderNo = orderNo
        protected set

    var memberId = memberId
        protected set

    var memberName = memberName
        protected set

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "order")
    var items = mutableListOf<OrderItemEntity>()
        protected set

    var canceledAt: LocalDateTime? = null
        protected set

    companion object {
        fun of(request: OrderCreateRequest, member: MemberDto): OrderEntity {
            val order = OrderEntity(
                orderNo = UUID.randomUUID().toString(),
                memberId = member.id,
                memberName = member.name,
            )
            val items = request.items.map {
                OrderItemEntity.of(it, order)
            }.toMutableList()

            return order
                .apply { addItems(items) }
                .also { it.produceOrderCreatedEvent() }
        }
    }

    fun cancel(canceledAt: LocalDateTime) {
        this.canceledAt = canceledAt
    }

    private fun addItems(items: List<OrderItemEntity>) {
        this.items.addAll(items)
    }

    private fun produceOrderCreatedEvent() {
        registerEvent(
            OrderCreatedEvent(
                orderId = this.id,
            )
        )
    }

}
