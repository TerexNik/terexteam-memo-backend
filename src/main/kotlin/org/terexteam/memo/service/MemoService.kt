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

    fun getAll(): List<MemoDTO> {
        return repository.findAll().map { memoMapper.toDTO(it) }
    }

    fun updateMemo(dto: MemoDTO): MemoDTO? {
        val entity = memoMapper.toEntity(dto)
        repository.save(entity)
        return memoMapper.toDTO(entity)
    }
}