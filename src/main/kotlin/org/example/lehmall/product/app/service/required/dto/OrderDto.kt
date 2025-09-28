package org.example.lehmall.product.app.service.required.dto

data class OrderDto(
    val id: Long,
    val productId: Long,
    val quantity: Int,
)
