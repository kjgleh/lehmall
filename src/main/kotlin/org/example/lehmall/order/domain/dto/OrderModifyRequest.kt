package org.example.lehmall.order.domain.dto

data class OrderModifyRequest(
    val orderer: Orderer? = null,
) {

    data class Orderer(
        val name: String? = null,
        val phone: String? = null,
    )
}
