@file:Suppress("ProtectedInFinal")

package org.example.lehmall.product.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "products")
class ProductEntity(
    name: String,
    quantity: Int,
) : AbstractEntity<ProductEntity>() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
        protected set

    var name = name
        protected set

    var quantity = quantity
        protected set

    var discountPolicyId: Long? = null
        protected set

    fun decrease(quantity: Int) {
        this.quantity = quantity
    }

    fun applyDiscount(policyId: Long) {
        this.discountPolicyId = policyId
    }

}
