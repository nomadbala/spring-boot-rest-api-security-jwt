package com.nomadbala.jwtTokens.controller.article

import com.nomadbala.jwtTokens.model.Article
import com.nomadbala.jwtTokens.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/article")
class ArticleController(
    private val service: ArticleService
) {
    @GetMapping
    fun findAll(): List<ArticleResponse> =
        service.findAll()
            .map { it.toResponse() }

    private fun Article.toResponse(): ArticleResponse =
        ArticleResponse(
            id = this.id,
            title = this.title,
            content = this.content,
        )
}