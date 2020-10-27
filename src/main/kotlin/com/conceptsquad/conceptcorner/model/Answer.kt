package com.conceptsquad.conceptcorner.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "answers")
data class Answer(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false)
        var description: String,

        @ManyToOne(optional = false)
        @JsonIgnore
        var question: Question,

        @ManyToOne(optional = false)
        var user: User,

        @OneToMany(mappedBy = "answer", targetEntity = AnswerVote::class)
        var votes : Set<AnswerVote> = HashSet(),

        var time: LocalDateTime = LocalDateTime.now()
)