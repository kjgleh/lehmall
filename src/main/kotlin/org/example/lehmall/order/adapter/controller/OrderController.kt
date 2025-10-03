package org.example.lehmall.order.adapter.controller

import org.example.lehmall.order.app.service.provided.OrderCanceler
import org.example.lehmall.order.app.service.provided.OrderFinder
import org.example.lehmall.order.app.service.provided.OrderReceiver
import org.example.lehmall.order.app.service.provided.dto.OrderCancelResponse
import org.example.lehmall.order.app.service.provided.dto.OrderFindResponse
import org.example.lehmall.order.app.service.provided.dto.OrderReceiveResponse
import org.example.lehmall.order.domain.dto.OrderReceiveRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderReceiver: OrderReceiver,
    private val orderFinder: OrderFinder,
    private val orderCanceler: OrderCanceler,
) {

    @PostMapping("/orders")
    fun create(@RequestBody request: OrderReceiveRequest): OrderReceiveResponse {
        return orderReceiver.receive(request)
    }

    @GetMapping("/orders/{id}")
    fun find(@PathVariable id: Long): OrderFindResponse {
        return orderFinder.find(id)
    }

    @PostMapping("/orders/{id}/cancel")
    fun cancel(@PathVariable id: Long): OrderCancelResponse {
        return orderCanceler.cancel(id)
    }
}
