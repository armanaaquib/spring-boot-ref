package com.conceptsquad.conceptcorner.controller

import com.conceptsquad.conceptcorner.repo.AnswerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/answer")
class AnswerController (private val repository: AnswerRepository){

    @GetMapping("/{questionId}")
    fun findAnswersByQuestionId(@PathVariable questionId: Long) =
            repository.findByQuestionIdOrderByTimeDesc(questionId)
}