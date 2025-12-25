package org.example.lehmall.discountpolicy.domain

import org.example.lehmall.common.Money

data class AmountDiscountPolicy(
    val amount: Money,
) : DiscountPolicy() {

    override val type: DiscountPolicyType = DiscountPolicyType.AMOUNT
    override fun calculate(price: Money): Money = price.minus(amount)
}
