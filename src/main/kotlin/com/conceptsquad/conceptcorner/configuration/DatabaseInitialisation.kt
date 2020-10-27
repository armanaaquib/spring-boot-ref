package com.conceptsquad.conceptcorner.configuration

import com.conceptsquad.conceptcorner.model.*
import com.conceptsquad.conceptcorner.repo.*
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("dev")
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
        val michel = userRepository.findByUsername("michel").first()
        val carlo = userRepository.findByUsername("carlo").first()
        val bryce = userRepository.findByUsername("bryce").first()
        val jake = userRepository.findByUsername("jake").first()

        val question1 = questionRepository.save(Question(
                title = "iOS: URLSession dataTask request block not called in background state2",
                user = michel,
                description = "I am working on framework that needs to be integrated in any iOS app. In my framework, there is one method (POST Reqeust) which needs to be executed when application"
        ))
        questionTagRepository.save(QuestionTag(tagName = "node", question = question1))
        questionTagRepository.save(QuestionTag(tagName = "c", question = question1))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question1))

        val question2 = questionRepository.save(Question(
                title = "All possible array initialization syntaxes2",
                user = carlo,
                description = "What are all the array initialization syntaxes that are possible with C#?"
        ))
        questionTagRepository.save(QuestionTag(tagName = "java", question = question2))
        questionTagRepository.save(QuestionTag(tagName = "C#", question = question2))

        val question3 = questionRepository.save(Question(
                title = "MOV DS, EAX segfaults?2",
                user = jake,
                description = "When I run mov ds,rax, it will throw error Program terminated with signal SIGSEGV, Segmentation fault What is wrong with the assembly code?"
        ))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question3))
        questionTagRepository.save(QuestionTag(tagName = "C#", question = question3))


        val question4 = questionRepository.save(Question(
                title = "Text-To-Speech Restarting2",
                user = bryce,
                description = "I have text-to-speech services in my app. I also have a Check Box. When the text-to-speech completed.I want the text-to-speech to be restarted all the time when the checkBox is true. Please anyone help me."
        ))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question4))
        questionTagRepository.save(QuestionTag(tagName = "node js", question = question4))

        val question5 = questionRepository.save(Question(
                title = "Calculate number of days between unix timestamps2",
                user = michel,
                description = "I have text-to-speech services in my app. I also have a Check Box. When the text-to-speech completed.I want the text-to-speech to be restarted all the time when the checkBox is true. Please anyone help me."
        ))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question5))
        questionTagRepository.save(QuestionTag(tagName = "node js", question = question5))

        val question6 = questionRepository.save(Question(
                title = "iOS: URLSession dataTask request block not called in background state",
                user = bryce,
                description = "I am working on framework that needs to be integrated in any iOS app. In my framework, there is one method (POST Reqeust) which needs to be executed when application"
        ))
        questionTagRepository.save(QuestionTag(tagName = "node", question = question6))
        questionTagRepository.save(QuestionTag(tagName = "c", question = question6))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question6))

        val question7 = questionRepository.save(Question(
                title = "All possible array initialization syntaxes",
                user = jake,
                description = "What are all the array initialization syntaxes that are possible with C#?"
        ))
        questionTagRepository.save(QuestionTag(tagName = "java", question = question7))
        questionTagRepository.save(QuestionTag(tagName = "C#", question = question7))

        val question8 = questionRepository.save(Question(
                title = "MOV DS, EAX segfaults?",
                user = michel,
                description = "When I run mov ds,rax, it will throw error Program terminated with signal SIGSEGV, Segmentation fault What is wrong with the assembly code?"
        ))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question8))
        questionTagRepository.save(QuestionTag(tagName = "C#", question = question8))

        val q5Answer1 = answerRepository.save(Answer(
                description = "In the first one, the size may be any non-negative integral value and the array elements are initialized to the default values." +
                        "In the second one, the size must be a constant and the number of elements given must match. ",
                question = question8,
                user = carlo))

        answerVoteRepository.save(AnswerVote(vote = "up", user = michel, answer = q5Answer1))
        answerVoteRepository.save(AnswerVote(vote = "up", user = carlo, answer = q5Answer1))
        answerVoteRepository.save(AnswerVote(vote = "up", user = bryce, answer = q5Answer1))
        answerVoteRepository.save(AnswerVote(vote = "down", user = jake, answer = q5Answer1))

        val q8Answer2 = answerRepository.save(Answer(
                description = "Out of curiosity, could someone explain why the initialisation expression in the 3rd line can't be used by itself (e.g. passed into a method) or be assigned to a var variable?",
                question = question8,
                user = jake))

        answerVoteRepository.save(AnswerVote(vote = "up", user = carlo, answer = q8Answer2))
        answerVoteRepository.save(AnswerVote(vote = "down", user = jake, answer = q8Answer2))


        val question9 = questionRepository.save(Question(
                title = "Text-To-Speech Restarting",
                user = carlo,
                description = "I have text-to-speech services in my app. I also have a Check Box. When the text-to-speech completed.I want the text-to-speech to be restarted all the time when the checkBox is true. Please anyone help me."
        ))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question9))
        questionTagRepository.save(QuestionTag(tagName = "node js", question = question9))

        val question10 = questionRepository.save(Question(
                title = "Calculate number of days between unix timestamps",
                user = michel,
                description = "I have text-to-speech services in my app. I also have a Check Box. When the text-to-speech completed.I want the text-to-speech to be restarted all the time when the checkBox is true. Please anyone help me."
        ))
        questionTagRepository.save(QuestionTag(tagName = "js", question = question10))
        questionTagRepository.save(QuestionTag(tagName = "node js", question = question10))
    }
}