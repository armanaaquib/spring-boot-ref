package com.conceptsquad.conceptcorner.controller

import com.conceptsquad.conceptcorner.model.Answer
import com.conceptsquad.conceptcorner.model.Question
import com.conceptsquad.conceptcorner.model.User
import com.conceptsquad.conceptcorner.repo.AnswerRepository
import com.conceptsquad.conceptcorner.repo.QuestionRepository
import com.conceptsquad.conceptcorner.repo.UserRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/answer")
class AnswerController(
        private val repository: AnswerRepository,
        private val questionRepository: QuestionRepository,
        private val userRepository: UserRepository
) {

    @GetMapping("/{questionId}")
    fun findAnswersByQuestionId(@PathVariable questionId: Long) =
            repository.findByQuestionIdOrderByTime(questionId)

    @PostMapping("/")
    fun saveAnswer(@RequestBody answerStat: AnswerStat) {
        val user: Optional<User> = userRepository.findById(answerStat.userId)
        val question: Optional<Question> = questionRepository.findById(answerStat.questionId)

        repository.save(Answer(description = answerStat.description, user = user.get(), question = question.get()))
    }

}

data class AnswerStat(val description: String, val questionId: Long, val userId: Long)
