package org.example.lehmall.discountpolicy.domain

data class PercentDiscountPolicy(
    override val type: DiscountPolicyType,
    val percent: Double,
) : DiscountPolicy
