package org.example.lehmall.order.domain.dto

import java.util.*
import org.example.lehmall.order.domain.dto.OrderModifyRequest.Orderer


object OrderModifyRequestFixture {

    fun of(
        orderer: Orderer? = null,
    ): OrderModifyRequest {
        return OrderModifyRequest(
            orderer = orderer,
        )
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
