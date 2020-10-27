package com.conceptsquad.conceptcorner.service

import com.conceptsquad.conceptcorner.dto.Users
import com.conceptsquad.conceptcorner.model.User
import com.conceptsquad.conceptcorner.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    private lateinit var userRepository: UserRepository

    fun getAllUsers(): Users {
        return Users(userRepository.findAll())
    }
}