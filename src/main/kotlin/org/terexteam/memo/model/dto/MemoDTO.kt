package org.terexteam.memo.model.dto

/**
 * @author nterehin on 24.01.2023
 */
data class MemoDTO(
    val id: Long? = null,
    val status: Boolean = false,
    val order: Int = 0,
    val content: String = "",
)