package org.example.lehmall.common

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.AbstractAggregateRoot
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class AbstractEntity<T : AbstractEntity<T>> : AbstractAggregateRoot<T>() {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    lateinit var createdAt: LocalDateTime

    @LastModifiedDate
    @Column(nullable = false)
    lateinit var updatedAt: LocalDateTime

    /**
     * 테스트나 애플리케이션에서 이벤트를 확인할 수 있게 노출
     */
    fun domainEventList() = super.domainEvents().toList()
}
