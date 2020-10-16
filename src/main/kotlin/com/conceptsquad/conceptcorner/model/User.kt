package com.conceptsquad.conceptcorner.model

import javax.persistence.*

@Entity
@Table(name = "users")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false, unique = true)
        var username: String,

        @Column(name = "avatar_url")
        var avatarUrl: String? = null
)