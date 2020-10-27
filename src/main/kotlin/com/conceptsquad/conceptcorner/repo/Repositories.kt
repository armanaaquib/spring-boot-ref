package com.conceptsquad.conceptcorner.repo

import com.conceptsquad.conceptcorner.model.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
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
    fun findByQuestionIdOrderByTime(questionId: Long): Iterable<Answer>
}

@Repository
interface AnswerVoteRepository: CrudRepository<AnswerVote, Long>