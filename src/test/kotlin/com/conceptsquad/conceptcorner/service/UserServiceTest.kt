package com.conceptsquad.conceptcorner.service

import com.conceptsquad.conceptcorner.dto.Users
import com.conceptsquad.conceptcorner.model.User
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
@Sql("/db-scripts/insert_into_users.sql")
class UserServiceTest {

    @Autowired
    private lateinit var userService: UserService

    @Test
    fun shouldGiveAllUsers() {
        val users = listOf(User(1,"michel"), User(2,"jack"))

        assertEquals(Users(users), userService.getAllUsers())
    }
}