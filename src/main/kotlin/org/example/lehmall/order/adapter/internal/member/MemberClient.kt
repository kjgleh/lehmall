package org.example.lehmall.order.adapter.internal.member

import org.example.lehmall.member.app.service.dto.MemberFindResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "MemberClient",
    url = "http://localhost:8080",
)
interface MemberClient {

    @GetMapping("/members/{id}")
    fun find(@PathVariable id: Long): MemberFindResponse
}
