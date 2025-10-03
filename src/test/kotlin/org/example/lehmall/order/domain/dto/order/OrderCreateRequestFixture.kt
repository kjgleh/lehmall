package org.example.lehmall.order.domain.dto.order

import java.util.*
import kotlin.random.Random
import org.example.lehmall.order.domain.dto.OrderReceiveRequest
import org.example.lehmall.order.domain.dto.OrderReceiveRequest.OrderItemDto
import org.example.lehmall.order.domain.dto.OrderReceiveRequest.Orderer

object OrderCreateRequestFixture {

    fun of(
        memberId: Long = Random.nextLong(1, 100),
        orderer: Orderer = OrdererFixture.of(),
        items: List<OrderItemDto> = listOf(
            OrderItemDtoFixture.of()
        ),
    ): OrderReceiveRequest {
        return OrderReceiveRequest(
            memberId = memberId,
            items = items,
            orderer = orderer,
        )
    }

    object OrderItemDtoFixture {
        fun of(
            productId: Long = Random.nextLong(1, 100),
            productName: String = "테스트 상품",
            quantity: Int = 1,
        ): OrderItemDto {
            return OrderItemDto(
                productId = productId,
                productName = productName,
                quantity = quantity,
            )
        }
    }

    object OrdererFixture {
        fun of(
            name: String = UUID.randomUUID().toString(),
            phone: String = UUID.randomUUID().toString(),
        ): Orderer {
            return Orderer(
                name = name,
                phone = phone,
            )
        }
    }
}
