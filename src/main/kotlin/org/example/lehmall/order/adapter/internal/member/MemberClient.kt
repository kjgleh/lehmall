package org.example.lehmall.order.adapter.internal.member

import org.example.lehmall.member.service.dto.MemberFindResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "MemberClient",
    url = "http://localhost:8080",
)
interface MemberClient {

    @GetMapping("/member/find")
    fun find(memberId: Long): MemberFindResponse
}
