package com.conceptsquad.conceptcorner.controller

import com.conceptsquad.conceptcorner.repo.QuestionRepository
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/question")
class QuestionController (private val repository: QuestionRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByTimeDesc()

    @GetMapping("/{id}")
    fun findByQuestionId(@PathVariable id: Long)  = repository.findById(id)
}