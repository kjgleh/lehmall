package org.example.lehmall.order.app.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

object RepositoryExtensions {

    fun <ID : Any, E : Any> JpaRepository<E, ID>.findByIdOrThrow(id: ID, message: String? = null): E {
        return this.findByIdOrNull(id)
            ?: throw IllegalArgumentException(message ?: "엔티티가 존재하지 않습니다.(ID: $id)")
    }
}
