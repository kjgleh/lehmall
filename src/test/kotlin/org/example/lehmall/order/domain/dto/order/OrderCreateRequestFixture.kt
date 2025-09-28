package org.example.lehmall.order.domain.dto.order

import kotlin.random.Random

object OrderCreateRequestFixture {

    fun of(
        memberId: Long = Random.nextLong(1, 100),
        items: List<OrderReceiveRequest.OrderItemDto> = listOf(
            OrderItemDtoFixture.of()
        ),
    ): OrderReceiveRequest {
        return OrderReceiveRequest(
            memberId = memberId,
            items = items,
        )
    }

    object OrderItemDtoFixture {

        fun of(
            productId: Long = Random.nextLong(1, 100),
            productName: String = "테스트 상품",
            quantity: Int = 1,
        ): OrderReceiveRequest.OrderItemDto {
            return OrderReceiveRequest.OrderItemDto(
                productId = productId,
                productName = productName,
                quantity = quantity,
            )
        }
    }
}
