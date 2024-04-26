package com.nomadbala.jwtTokens.service

import com.nomadbala.jwtTokens.model.Article
import com.nomadbala.jwtTokens.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val repository: ArticleRepository
) {
    fun findAll(): List<Article> =
        repository.findAll()
}