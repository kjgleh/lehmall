package org.example.lehmall.order.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.example.lehmall.order.domain.dto.order.OrderCreateRequest.OrderItemDto

@Entity(name = "order_items")
class OrderItemEntity(
    order: OrderEntity,
    productId: Long,
    productName: String,
    quantity: Int,
) : AbstractEntity<OrderItemEntity>() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    var order: OrderEntity = order
        protected set

    var productId = productId
        protected set

    var productName = productName
        protected set

    var quantity = quantity
        protected set

    companion object {
        fun of(item: OrderItemDto, order: OrderEntity): OrderItemEntity {
            return OrderItemEntity(
                order = order,
                productId = item.productId,
                productName = item.productName,
                quantity = item.quantity,
            )
        }
    }

}
