package org.example.lehmall.order.domain

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import org.example.lehmall.order.domain.dto.OrderModifyRequest
import org.example.lehmall.order.domain.dto.OrderReceiveRequest

@Embeddable
data class Orderer(
    @Column(name = "orderer_name")
    val name: String,

    @Column(name = "orderer_phone")
    val phone: String,
) {

    fun modify(orderer: OrderModifyRequest.Orderer?) {
    }


    companion object {
        fun of(orderer: OrderReceiveRequest.Orderer): Orderer {
            return Orderer(
                name = orderer.name,
                phone = orderer.phone,
            )
        }
    }
}
