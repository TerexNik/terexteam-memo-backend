package org.terexteam.memo.model

import jakarta.persistence.*

/**
 * @author nterehin on 21.01.2023
 */
@Entity
@Table(name = "memo")
data class Memo(
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column
    val status: Boolean = false,
    @Column(name = "orderNum")
    val order: Int = 0,
    @Column
    val content: String = "",
)