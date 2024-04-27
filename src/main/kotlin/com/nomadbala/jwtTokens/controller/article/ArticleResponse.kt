package com.nomadbala.jwtTokens.controller.article

import java.util.*

data class ArticleResponse(
    val id: Long,
    val title: String,
    val content: String
)
