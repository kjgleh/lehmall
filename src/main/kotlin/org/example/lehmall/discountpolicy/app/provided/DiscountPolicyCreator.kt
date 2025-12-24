package org.example.lehmall.discountpolicy.app.provided

import org.example.lehmall.discountpolicy.domain.DiscountPolicyCreateRequest

interface DiscountPolicyCreator {
    fun create(request: DiscountPolicyCreateRequest)
}
