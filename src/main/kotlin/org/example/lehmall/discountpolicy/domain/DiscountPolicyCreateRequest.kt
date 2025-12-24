package org.example.lehmall.discountpolicy.domain

import org.example.lehmall.common.Money

data class DiscountPolicyCreateRequest(
    val type: DiscountPolicyType,
    val amount: Money? = null,
    val percent: Double? = null,
)
