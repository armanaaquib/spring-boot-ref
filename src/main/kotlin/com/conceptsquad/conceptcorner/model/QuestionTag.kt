package com.conceptsquad.conceptcorner.model

//import java.io.Serializable
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

//@Embeddable
//class QuestionTagKey(
//        @Column(name = "tag_name")
//        var tag_name: String,
//
//        @Column
//        var question_id: Long
//) : Serializable

@Entity
@Table(name = "question_tags")
data class QuestionTag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "tag_name")
        var tagName: String,

        @JsonIgnore
        @ManyToOne(optional = false)
        var question: Question
)