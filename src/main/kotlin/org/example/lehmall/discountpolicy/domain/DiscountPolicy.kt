package org.example.lehmall.discountpolicy.domain

import org.example.lehmall.common.Money

sealed interface DiscountPolicy {
    fun calculate(price: Money): Money
}
