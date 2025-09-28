package org.example.lehmall.order.domain.dto.order

data class OrderReceiveRequest(
    val memberId: Long,
    val items: List<OrderItemDto>,
) {

    data class OrderItemDto(
        val productId: Long,
        val productName: String,
        val quantity: Int,
    )
}
