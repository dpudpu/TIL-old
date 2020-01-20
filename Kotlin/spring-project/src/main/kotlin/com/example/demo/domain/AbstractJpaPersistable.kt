package com.example.demo.domain

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractJpaPersistable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long? = null

    @CreatedBy
    @Column(updatable = false, length = 65)
    var createdBy: String = ""

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createAt: LocalDateTime? = null

    @LastModifiedDate
    @Column(nullable = false)
    var lastModifiedAt: LocalDateTime? = null

    @Column(nullable = false, columnDefinition = "BIT default 0")
    private var deleted: Boolean = false

    fun getId() : Long? {
        return id
    }

    override fun toString(): String {
        return "id=$id, createdBy='$createdBy', createAt=$createAt, lastModifiedAt=$lastModifiedAt, deleted=$deleted"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AbstractJpaPersistable

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }


}