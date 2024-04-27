package com.nomadbala.jwtTokens.repository

import com.nomadbala.jwtTokens.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {

    private val articles: MutableList<Article> = ArrayList()

    fun findAll(): List<Article> = articles;
}