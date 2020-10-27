package com.conceptsquad.conceptcorner.repo

import com.conceptsquad.conceptcorner.model.User
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class RepositoriesTests {

    @Autowired
    private lateinit var entityManager: TestEntityManager

    @Autowired
    private lateinit var userRepository: UserRepository

//    @Test
//    fun testFindByUsername() {
//        val username = "armanaaquib"
//        entityManager.persist(User(username = username))
//
//        val user = userRepository.findByUsername(username).first()
//
//        assertEquals(user.username, username)
//    }
}