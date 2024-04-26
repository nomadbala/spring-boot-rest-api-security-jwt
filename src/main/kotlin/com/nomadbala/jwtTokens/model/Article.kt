package com.nomadbala.jwtTokens.model

import java.rmi.server.UID
import java.util.UUID

data class Article (
    val id: UUID,
    val title: String,
    val content: String,
)
