package org.example.lehmall.member.adapter.webapi

import org.example.lehmall.member.service.MemberFindService
import org.example.lehmall.member.service.dto.MemberFindResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberFindService: MemberFindService,
) {

    @GetMapping("/members/{id}")
    fun find(@PathVariable id: Long): MemberFindResponse {
        return memberFindService.find(id)
    }
}
