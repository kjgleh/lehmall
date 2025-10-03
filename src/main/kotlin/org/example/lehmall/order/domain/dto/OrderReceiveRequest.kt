package org.example.lehmall.order.domain.dto

data class OrderReceiveRequest(
    val memberId: Long,
    val orderer: Orderer,
    val items: List<OrderItemDto>,
) {

    data class OrderItemDto(
        val productId: Long,
        val productName: String,
        val quantity: Int,
    )

    data class Orderer(
        val name: String,
        val phone: String,
    )
}
