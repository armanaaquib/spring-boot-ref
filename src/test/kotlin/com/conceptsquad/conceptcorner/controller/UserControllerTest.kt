package com.conceptsquad.conceptcorner.controller

import com.conceptsquad.conceptcorner.dto.Users
import com.conceptsquad.conceptcorner.model.User
import com.conceptsquad.conceptcorner.service.UserService
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
class UserControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var jacksonBuilder: Jackson2ObjectMapperBuilder

    @MockBean
    private lateinit var userService: UserService

    @Test
    fun shouldGiveAllUsers() {
        val users = Users(listOf(User(1, "michel")))
        given(userService.getAllUsers()).willReturn(users)

        val mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/user/"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()

        val objectMapper: ObjectMapper = jacksonBuilder.build()
        val actualUsers = objectMapper.readValue(mvcResult.response.contentAsString, Users::class.java)

        assertEquals(users, actualUsers)
    }
}