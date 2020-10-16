package com.conceptsquad.conceptcorner.repo

import com.conceptsquad.conceptcorner.model.*
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): Iterable<User>
}

@Repository
interface QuestionRepository: CrudRepository<Question, Long> {
    fun findAllByOrderByTimeDesc(): Iterable<Question>
}

@Repository
interface QuestionTagRepository: CrudRepository<QuestionTag, Long>

@Repository
interface AnswerRepository: CrudRepository<Answer, Long> {
    fun findByQuestionIdOrderByTimeDesc(questionId: Long): Iterable<Answer>
}

@Repository
interface AnswerVoteRepository: CrudRepository<AnswerVote, Long>