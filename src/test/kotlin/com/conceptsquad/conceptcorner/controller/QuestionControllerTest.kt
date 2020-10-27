package com.conceptsquad.conceptcorner.controller

import com.conceptsquad.conceptcorner.dto.Questions
import com.conceptsquad.conceptcorner.model.Question
import com.conceptsquad.conceptcorner.model.User
import com.conceptsquad.conceptcorner.repo.QuestionRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var jacksonBuilder: Jackson2ObjectMapperBuilder


    @MockBean
    private lateinit var questionRepository: QuestionRepository

//    @Test
//    fun shouldGiveAllQuestions() {
//        val questions = listOf(Question(title = "title", user = User(username = "michel")))
//
//        given(questionRepository.findAllByOrderByTimeDesc()).willReturn(questions)
//
//        val mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/question/")).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
//
//        println(mvcResult.response.contentAsString)
//
//        val objectMapper = jacksonBuilder.build<ObjectMapper>()
//
//        val actualQuestions = objectMapper.readValue(objectMapper.writeValueAsString(mvcResult.response), Questions::class.java)
//        assertEquals(questions, actualQuestions)
//    }
}