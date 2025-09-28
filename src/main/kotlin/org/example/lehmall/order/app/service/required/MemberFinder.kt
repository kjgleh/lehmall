package org.example.lehmall.order.app.service.required

import org.example.lehmall.order.domain.dto.member.MemberDto

interface MemberFinder {

    fun find(memberId: Long): MemberDto

}
