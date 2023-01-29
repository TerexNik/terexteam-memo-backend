package org.terexteam.memo.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
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

    @GetMapping
    fun getAllMemo(): List<MemoDTO> {
        return service.getAll();
    }

    @PostMapping
    fun createMemo(@RequestBody dto: MemoDTO): MemoDTO {
        return service.createMemo(dto)
    }

    @PutMapping
    fun updateMemo(@RequestBody dto: MemoDTO): ResponseEntity<MemoDTO> {
        val result = service.updateMemo(dto)
        if (result != null) {
            return ResponseEntity.ok(result)
        } else {
            return ResponseEntity.notFound().build()
        }
    }
}