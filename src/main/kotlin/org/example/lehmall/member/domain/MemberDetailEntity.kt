package org.example.lehmall.member.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity(name = "members")
class MemberDetailEntity(
    member: MemberEntity,
    introduction: String,
) : AuditingDate() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
        protected set

    @OneToOne
    @JoinColumn(name = "member_id")
    var member: MemberEntity = member
        protected set

    var introduction = introduction
        protected set

}
