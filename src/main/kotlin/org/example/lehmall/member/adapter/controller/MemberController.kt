package org.example.lehmall.member.adapter.controller

import org.example.lehmall.member.app.service.provided.MemberFinder
import org.example.lehmall.member.app.service.provided.dto.MemberFindResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val memberFinder: MemberFinder,
) {

    @GetMapping("/members/{id}")
    fun find(@PathVariable id: Long): MemberFindResponse {
        return memberFinder.find(id)
    }
}
