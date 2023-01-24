package org.terexteam.memo.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.terexteam.memo.model.dto.MemoDTO
import org.terexteam.memo.service.MemoService

/**
 * @author nterehin on 24.01.2023
 */
@RestController
@RequestMapping("/memo")
class MemoController(
    private val service: MemoService
) {

    @PostMapping
    fun createMemo(@RequestBody dto: MemoDTO): MemoDTO {
        return service.createMemo(dto)
    }
}