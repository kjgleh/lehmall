package org.example.lehmall.product.app.service.provided

interface ProductUpdater {
    fun applyDiscount(productId: Long, policyId: Long)
}
