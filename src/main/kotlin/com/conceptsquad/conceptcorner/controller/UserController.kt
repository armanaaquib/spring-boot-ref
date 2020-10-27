package com.conceptsquad.conceptcorner.controller

import com.conceptsquad.conceptcorner.dto.Users
import com.conceptsquad.conceptcorner.model.User
import com.conceptsquad.conceptcorner.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/")
    fun findAllUsers(): ResponseEntity<Users> {
        return ResponseEntity.ok(userService.getAllUsers())
    }
}