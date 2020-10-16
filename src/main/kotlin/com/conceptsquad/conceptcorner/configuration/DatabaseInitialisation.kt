package com.conceptsquad.conceptcorner.configuration

import com.conceptsquad.conceptcorner.model.*
import com.conceptsquad.conceptcorner.repo.*
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseInitialisation {

    @Bean
    fun userInitializer(userRepository: UserRepository) = ApplicationRunner {
        userRepository.save(User(username = "armanaaquib"))
        userRepository.save(User(username = "michel"))
        userRepository.save(User(username = "bryce"))
        userRepository.save(User(username = "jake"))
        userRepository.save(User(username = "carlo"))
    }

    @Bean
    fun questionInitializer(
            userRepository: UserRepository,
            questionRepository: QuestionRepository,
            questionTagRepository: QuestionTagRepository,
            answerRepository: AnswerRepository,
            answerVoteRepository: AnswerVoteRepository
    ) = ApplicationRunner {
        val michel = userRepository.findByUsername("michel").first();
        val carlo = userRepository.findByUsername("carlo").first();

        val question = questionRepository.save(Question(title = "title", user = michel, description = "description"))

        questionTagRepository.save(QuestionTag(tagName = "kotlin", question = question))

        val answer = answerRepository.save(Answer(description = "answer1", question = question, user=carlo))

        answerVoteRepository.save(AnswerVote(vote = "up", user = michel, answer = answer))
    }
}