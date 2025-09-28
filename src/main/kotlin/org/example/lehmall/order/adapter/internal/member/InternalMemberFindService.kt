package org.example.lehmall.order.adapter.internal.member

import org.example.lehmall.member.app.service.dto.MemberFindResponse
import org.example.lehmall.order.app.service.required.MemberFinder
import org.example.lehmall.order.domain.dto.member.MemberDto
import org.springframework.stereotype.Service

@Service // Member 애플리케이션의 MemberFindService와 이름 충돌
class InternalMemberFindService(
    private val memberClient: MemberClient,
) : MemberFinder {

    override fun find(memberId: Long): MemberDto {
        return memberClient.find(memberId).toDto()
    }

    private fun MemberFindResponse.toDto(): MemberDto {
        return MemberDto(
            id = id,
            name = name,
        )
    }

}
