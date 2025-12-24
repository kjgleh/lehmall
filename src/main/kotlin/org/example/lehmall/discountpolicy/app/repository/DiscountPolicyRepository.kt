package org.example.lehmall.discountpolicy.app.repository

import org.example.lehmall.discountpolicy.domain.DiscountPolicyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DiscountPolicyRepository : JpaRepository<DiscountPolicyEntity, Long>
