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

    fun changedBy(orderer: OrderModifyRequest.Orderer?): Orderer {
        if (orderer == null) {
            return this
        }

        return orderer.let {
            copy(
                name = it.name ?: this.name,
                phone = it.phone ?: this.phone
            )
        }
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
