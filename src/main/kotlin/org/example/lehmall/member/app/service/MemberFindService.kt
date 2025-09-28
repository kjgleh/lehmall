package org.example.lehmall.member.app.service

import org.example.lehmall.member.app.service.dto.MemberFindResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberFindService {

    fun find(id: Long): MemberFindResponse {
        TODO("Not yet implemented")
    }
}
