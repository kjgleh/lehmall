package org.example.lehmall.product.app.repository

import org.example.lehmall.product.domain.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, Long>
