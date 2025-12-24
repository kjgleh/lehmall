package org.example.lehmall.discountpolicy.domain

import org.example.lehmall.common.Money

data class AmountDiscountPolicy(
    override val type: DiscountPolicyType,
    val amount: Money,
) : DiscountPolicy
