package com.nomadbala.jwtTokens.repository

import com.nomadbala.jwtTokens.model.Role
import com.nomadbala.jwtTokens.model.User
import com.nomadbala.jwtTokens.service.UserAlreadyExistsException
import com.nomadbala.jwtTokens.service.UserNotFoundException
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {
    private val users : MutableList<User> = ArrayList()

    fun findAll(): List<User> =
        users

    fun save(user: User): User {
        if (users.any { it.id == user.id })
            throw UserAlreadyExistsException("User with email ${user.email} already exists")

        users.add(user)
        return user
    }

    fun deleteByUUID(uuid: Long): Boolean {
        if (!users.any { it.id == uuid })
            throw UserNotFoundException("User with uuid $uuid not found")

        val foundUser = findByUUID(uuid)

        return users.remove(foundUser)
    }

    fun findByEmail(email: String): User {
        val foundUser = users
            .firstOrNull { it.email == email }

        return foundUser ?: throw UserNotFoundException("User with email $email not found")
    }

    fun findByUUID(uuid: Long): User {
        val foundUser = users
            .firstOrNull { it.id == uuid }

        return foundUser ?: throw UserNotFoundException("User with uuid $uuid not found")
    }
}