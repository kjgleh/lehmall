package org.example.lehmall.common

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
) {

    companion object {
        val ZERO = Money(BigDecimal.ZERO)

        fun wons(amount: Long) = Money(BigDecimal.valueOf(amount))
    }

    fun plus(amount: Money): Money {
        return Money(this.amount.plus(amount.amount))
    }

    fun minus(amount: Money): Money {
        return Money(this.amount.minus(amount.amount))
    }

    fun times(percent: Double): Money {
        return Money(this.amount.times(BigDecimal.valueOf(percent)))
    }
}
