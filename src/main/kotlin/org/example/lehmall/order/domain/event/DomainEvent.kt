package org.example.lehmall.order.domain.event

import java.time.LocalDateTime

abstract class DomainEvent {
    val occurredAt: LocalDateTime = LocalDateTime.now()
}