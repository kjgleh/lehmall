package org.example.lehmall.product.app.service.provided.impl

import org.example.lehmall.common.RepositoryExtensions.findByIdOrThrow
import org.example.lehmall.product.app.repository.ProductRepository
import org.example.lehmall.product.app.service.provided.StockManager
import org.example.lehmall.product.app.service.provided.dto.StockDecreaseResponse
import org.example.lehmall.product.app.service.required.OrderFinder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StockManageService(
    private val orderFinder: OrderFinder,
    private val productRepository: ProductRepository,
) : StockManager {

    override fun decrease(orderId: Long): StockDecreaseResponse {
        val order = orderFinder.find(orderId)

        val product = productRepository.findByIdOrThrow(order.productId)

        product.decrease(order.quantity)

        productRepository.save(product)

        return StockDecreaseResponse(product.id)
    }

}
