package org.example.lehmall.product.app.service

import org.example.lehmall.common.RepositoryExtensions.findByIdOrThrow
import org.example.lehmall.product.app.repository.ProductRepository
import org.example.lehmall.product.app.service.provided.ProductUpdater
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProductUpdateService(
    private val productRepository: ProductRepository,
) : ProductUpdater {

    override fun applyDiscount(productId: Long, policyId: Long) {
        val product = productRepository.findByIdOrThrow(productId)

        product.applyDiscount(policyId)

        productRepository.save(product)
    }
}
