package org.example.lehmall.discountpolicy.domain

import org.example.lehmall.common.Money

data class PercentDiscountPolicy(
    val percent: Double,
) : DiscountPolicy() {

    override val type: DiscountPolicyType = DiscountPolicyType.PERCENT
    override fun calculate(price: Money): Money = price.times((1 - percent / 100))

}
