@file:Suppress("ProtectedInFinal")

package org.example.lehmall.discountpolicy.domain

import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.example.lehmall.common.AbstractEntity
import org.example.lehmall.common.Money
import org.example.lehmall.common.MoneyConverter

@Entity(name = "discount_policies")
class DiscountPolicyEntity protected constructor(
    type: DiscountPolicyType,
    amount: Money? = null,
    percent: Double? = null,
) : AbstractEntity<DiscountPolicyEntity>() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
        protected set

    @Enumerated(EnumType.STRING)
    var type: DiscountPolicyType = type
        protected set

    // TODO Money를 embeddable로 변환
    @Convert(converter = MoneyConverter::class)
    var amount: Money? = amount
        protected set

    var percent: Double? = percent
        protected set

    companion object {
        fun of(discountPolicy: DiscountPolicy): DiscountPolicyEntity {
            return when (discountPolicy) {
                is AmountDiscountPolicy -> {
                    amount(discountPolicy.amount)
                }

                is PercentDiscountPolicy -> {
                    percent(discountPolicy.percent)
                }
            }
        }

        private fun amount(amount: Money): DiscountPolicyEntity {
            return DiscountPolicyEntity(
                type = DiscountPolicyType.AMOUNT,
                amount = amount,
            )
        }

        private fun percent(percent: Double): DiscountPolicyEntity {
            return DiscountPolicyEntity(
                type = DiscountPolicyType.PERCENT,
                percent = percent,
            )
        }
    }

    fun toDomain(): DiscountPolicy = when (type) {
        DiscountPolicyType.AMOUNT -> AmountDiscountPolicy(requireNotNull(amount))
        DiscountPolicyType.PERCENT -> PercentDiscountPolicy(requireNotNull(percent))
    }

}
