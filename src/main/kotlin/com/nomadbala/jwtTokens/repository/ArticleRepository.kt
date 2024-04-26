package com.nomadbala.jwtTokens.repository

import com.nomadbala.jwtTokens.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {

    private val articles: List<Article> = listOf(
        Article(id = UUID.randomUUID(), title = "Article 1", content = "Content 1"),
        Article(id = UUID.randomUUID(), title = "Article 2", content = "Content 2"),
        Article(id = UUID.randomUUID(), title = "Article 3", content = "Content 3"),
    )

    fun findAll(): List<Article> = articles;
}