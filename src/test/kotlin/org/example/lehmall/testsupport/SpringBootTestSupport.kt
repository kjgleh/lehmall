@file:Suppress("unused")

package org.example.lehmall.testsupport

import com.ninjasquad.springmockk.MockkBean
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.example.lehmall.config.TestClockConfig
import org.example.lehmall.order.app.service.MemberFindService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@ActiveProfiles("test")
@Import(TestClockConfig::class)
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
