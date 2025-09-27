package org.example.lehmall.order.app.service

import org.example.lehmall.order.domain.dto.member.MemberDto

interface MemberFindService {
    fun find(memberId: Long): MemberDto
}
