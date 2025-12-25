package org.example.lehmall.discountpolicy.domain

import org.example.lehmall.common.Money

sealed class DiscountPolicy {
    abstract fun calculate(price: Money): Money
}
