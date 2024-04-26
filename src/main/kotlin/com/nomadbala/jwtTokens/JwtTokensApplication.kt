package com.nomadbala.jwtTokens

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JwtTokensApplication

fun main(args: Array<String>) {
	runApplication<JwtTokensApplication>(*args)
}
