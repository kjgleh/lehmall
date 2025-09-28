package org.example.lehmall.product.app.service.provided

import org.example.lehmall.product.app.service.provided.dto.StockDecreaseResponse

interface StockManager {

    fun decrease(orderId: Long): StockDecreaseResponse

}
