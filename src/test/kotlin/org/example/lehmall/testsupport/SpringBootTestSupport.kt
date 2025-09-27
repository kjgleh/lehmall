@file:Suppress("unused")

package org.example.lehmall.testsupport

import com.ninjasquad.springmockk.MockkBean
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.example.lehmall.order.service.MemberFindService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@ActiveProfiles("test")
@Transactional
abstract class SpringBootTestSupport {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    protected fun flushAndClear() {
        entityManager.flush()
        entityManager.clear()
    }

    @MockkBean
    protected lateinit var memberFindService: MemberFindService
}
