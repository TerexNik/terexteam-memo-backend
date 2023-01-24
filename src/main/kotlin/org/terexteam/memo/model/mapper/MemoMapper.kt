package org.terexteam.memo.model.mapper

import org.springframework.stereotype.Component
import org.terexteam.memo.model.Memo
import org.terexteam.memo.model.dto.MemoDTO

/**
 * @author nterehin on 24.01.2023
 */
@Component
class MemoMapper {
    fun toEntity(dto: MemoDTO) = Memo(
        id = dto.id,
        status = dto.status,
        order = dto.order,
        content = dto.content,
    )

    fun toDTO(entity: Memo) = MemoDTO(
        id = entity.id,
        status = entity.status,
        order = entity.order,
        content = entity.content,
    )
}