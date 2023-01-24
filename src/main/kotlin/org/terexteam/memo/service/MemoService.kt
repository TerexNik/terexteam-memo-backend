package org.terexteam.memo.service

import org.springframework.stereotype.Service
import org.terexteam.memo.model.dto.MemoDTO
import org.terexteam.memo.model.mapper.MemoMapper
import org.terexteam.memo.repository.MemoRepository

/**
 * @author nterehin on 24.01.2023
 */
@Service
class MemoService(
    private val repository: MemoRepository,
    private val memoMapper: MemoMapper,
) {
    fun createMemo(dto: MemoDTO): MemoDTO {
        val entity = repository.save(memoMapper.toEntity(dto))
        return memoMapper.toDTO(entity)
    }
}