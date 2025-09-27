package org.example.lehmall.order.adapter.webapi

import org.example.lehmall.order.domain.dto.order.OrderCreateRequest
import org.example.lehmall.order.service.OrderCancelService
import org.example.lehmall.order.service.OrderCreateService
import org.example.lehmall.order.service.OrderFindService
import org.example.lehmall.order.service.dto.OrderCancelResponse
import org.example.lehmall.order.service.dto.OrderCreateResponse
import org.example.lehmall.order.service.dto.OrderFindResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val orderCreateService: OrderCreateService,
    private val orderFindService: OrderFindService,
    private val orderCancelService: OrderCancelService,
) {

    @PostMapping("/orders")
    fun create(@RequestBody request: OrderCreateRequest): OrderCreateResponse {
        return orderCreateService.create(request)
    }

    @GetMapping("/orders/{id}")
    fun find(@PathVariable id: Long): OrderFindResponse {
        return orderFindService.find(id)
    }

    @PostMapping("/orders/{id}/cancel")
    fun cancel(@PathVariable id: Long): OrderCancelResponse {
        return orderCancelService.cancel(id)
    }
}
