package org.example.lehmall.member.app.service.provided

import org.example.lehmall.member.app.service.provided.dto.MemberFindResponse

interface MemberFinder {

    fun find(id: Long): MemberFindResponse

}
