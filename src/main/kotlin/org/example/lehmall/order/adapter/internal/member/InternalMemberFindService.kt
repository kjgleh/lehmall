package org.example.lehmall.order.adapter.internal.member

import org.example.lehmall.member.service.dto.MemberFindResponse
import org.example.lehmall.order.domain.dto.member.MemberDto
import org.example.lehmall.order.service.MemberFindService
import org.springframework.stereotype.Service

@Service
class InternalMemberFindService(
    private val memberClient: MemberClient,
) : MemberFindService {

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
