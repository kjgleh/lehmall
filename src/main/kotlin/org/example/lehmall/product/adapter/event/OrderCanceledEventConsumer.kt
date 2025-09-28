package org.example.lehmall.product.adapter.event

import org.example.lehmall.order.domain.event.OrderCanceledEvent
import org.example.lehmall.product.app.service.provided.StockManager
import org.springframework.stereotype.Component

@Component
class OrderCanceledEventConsumer(
    private val stockManager: StockManager,
) {

    fun consume(event: OrderCanceledEvent) {
        stockManager.decrease(event.orderId)
    }
}
