package com.nomadbala.jwtTokens.service

import com.nomadbala.jwtTokens.model.Article
import com.nomadbala.jwtTokens.repository.ArticleRepository
import org.springframework.stereotype.Service

interface IArticleService {
    fun findAll(): List<Article>
}

@Service
class ArticleService(
    private val repository: ArticleRepository
) : IArticleService {
    override fun findAll(): List<Article> =
        repository.findAll()
}