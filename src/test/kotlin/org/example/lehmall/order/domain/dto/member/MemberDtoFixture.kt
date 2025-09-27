package org.example.lehmall.order.domain.dto.member

import kotlin.random.Random

object MemberDtoFixture {

    fun of(
        id: Long = Random.nextLong(1, 100),
        name: String = "홍길동",
    ): MemberDto {
        return MemberDto(
            id = id,
            name = name,
        )
    }

}
