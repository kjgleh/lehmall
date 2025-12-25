package org.example.lehmall.discountpolicy.app

import org.example.lehmall.discountpolicy.app.provided.DiscountPolicyCreator
import org.example.lehmall.discountpolicy.app.repository.DiscountPolicyRepository
import org.example.lehmall.discountpolicy.domain.AmountDiscountPolicy
import org.example.lehmall.discountpolicy.domain.DiscountPolicy
import org.example.lehmall.discountpolicy.domain.DiscountPolicyCreateRequest
import org.example.lehmall.discountpolicy.domain.DiscountPolicyEntity
import org.example.lehmall.discountpolicy.domain.DiscountPolicyType
import org.example.lehmall.discountpolicy.domain.PercentDiscountPolicy
import org.springframework.stereotype.Service

@Service
class DiscountPolicyCreateService(
    private val discountPolicyRepository: DiscountPolicyRepository,
) : DiscountPolicyCreator {

    override fun create(request: DiscountPolicyCreateRequest) {
        val discountPolicy = createDiscountPolicy(request)

        save(discountPolicy)
    }

    private fun save(discountPolicy: DiscountPolicy) {
        val entity = DiscountPolicyEntity.of(discountPolicy)

        discountPolicyRepository.save(entity)
    }

    private fun createDiscountPolicy(request: DiscountPolicyCreateRequest): DiscountPolicy {
        return when (request.type) {
            DiscountPolicyType.AMOUNT -> AmountDiscountPolicy(
                amount = requireNotNull(request.amount)
            )

            DiscountPolicyType.PERCENT -> PercentDiscountPolicy(
                percent = requireNotNull(request.percent)
            )
        }
    }
}
