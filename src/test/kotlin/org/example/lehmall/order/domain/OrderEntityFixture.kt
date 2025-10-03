package org.example.lehmall.order.domain

import java.util.*
import kotlin.random.Random
import org.springframework.test.util.ReflectionTestUtils

object OrderEntityFixture {

    fun of(
        id: Long? = null,
        orderNo: String = UUID.randomUUID().toString(),
        memberId: Long = Random.nextLong(1, 100),
        memberName: String = "홍길동",
        orderer: Orderer = OrdererFixture.of(),
    ): OrderEntity {
        return OrderEntity(
            orderNo = orderNo,
            memberId = memberId,
            memberName = memberName,
            orderer = orderer,
        ).apply {
            id?.let { ReflectionTestUtils.setField(this, "id", it) }
        }
    }

    object OrdererFixture {
        fun of(
            name: String = UUID.randomUUID().toString(),
            phone: String = UUID.randomUUID().toString(),
        ): Orderer {
            return Orderer(
                name = name,
                phone = phone,
            )
        }
    }

}
