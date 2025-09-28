package org.example.lehmall.member.app.service

import org.example.lehmall.member.app.service.provided.MemberFinder
import org.example.lehmall.member.app.service.provided.dto.MemberFindResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberFindService : MemberFinder {

    override fun find(id: Long): MemberFindResponse {
        TODO("Not yet implemented")
    }
}
