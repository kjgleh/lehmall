package org.example.lehmall.discountpolicy.app.provided

import org.example.lehmall.common.Money

interface DiscountPolicyApplier {
    fun applyDiscount(policyId: Long, price: Money): Money
}
