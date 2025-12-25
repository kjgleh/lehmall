package org.example.lehmall.discountpolicy.app

import org.example.lehmall.common.Money
import org.example.lehmall.common.RepositoryExtensions.findByIdOrThrow
import org.example.lehmall.discountpolicy.app.provided.DiscountPolicyApplier
import org.example.lehmall.discountpolicy.app.repository.DiscountPolicyRepository
import org.springframework.stereotype.Service

@Service
class DiscountPolicyApplyService(
    private val discountPolicyRepository: DiscountPolicyRepository,
) : DiscountPolicyApplier {

    override fun applyDiscount(policyId: Long, price: Money): Money {
        val entity = discountPolicyRepository.findByIdOrThrow(policyId)
        val policy = entity.toDomain()  // Entity → Domain 변환

        return policy.calculate(price)   // 도메인 로직 사용
    }

}
