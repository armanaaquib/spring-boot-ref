package com.conceptsquad.conceptcorner.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "answer_votes")
data class AnswerVote(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @ManyToOne(optional = false)
        var user: User,

        @JsonIgnore
        @ManyToOne(optional = false)
        var answer: Answer,

        @Column(nullable = false)
        var vote: String
)