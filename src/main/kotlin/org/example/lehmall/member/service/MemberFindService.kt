package org.example.lehmall.member.service

import org.example.lehmall.member.service.dto.MemberFindResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberFindService {

    fun find(id: Long): MemberFindResponse {
        TODO("Not yet implemented")
    }
}
