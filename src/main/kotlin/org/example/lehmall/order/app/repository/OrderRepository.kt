package org.example.lehmall.order.app.repository

import org.example.lehmall.order.domain.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, Long>
