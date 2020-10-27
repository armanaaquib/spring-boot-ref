package com.conceptsquad.conceptcorner.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "questions")
data class Question(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(nullable = false, unique = true)
        var title: String,

        @ManyToOne(optional = false)
        var user: User,

        @OneToMany(mappedBy = "question", targetEntity = Answer::class,  cascade = [CascadeType.ALL])
        var answers: Set<Answer> = HashSet(),

        @OneToMany(mappedBy = "question", targetEntity = QuestionTag::class, cascade = [CascadeType.ALL])
        var tags: Set<QuestionTag> = HashSet(),

        var description: String? = null,

        var time: LocalDateTime = LocalDateTime.now()
)