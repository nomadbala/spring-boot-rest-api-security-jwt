package com.nomadbala.jwtTokens.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import java.util.*

@Entity
@Table(name = "article")
@AllArgsConstructor
@RequiredArgsConstructor
open class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article", nullable = false)
    open var id: Long = 0

    @Column(name = "title")
    open var title: String = ""

    @Column(name = "content")
    open var content: String = ""
}
