package com.nomadbala.jwtTokens.service

import com.nomadbala.jwtTokens.model.User
import com.nomadbala.jwtTokens.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

interface IUserService {
    @Throws(UserAlreadyExistsException::class)
    fun createUser(user: User): User

    @Throws(UserNotFoundException::class)
    fun deleteByUUID(uuid: Long) : Boolean

    @Throws(UserNotFoundException::class)
    fun findByUUID(uuid: Long) : User

    fun findAll() : List<User>
}

@Service
class UserService(
    private val repository: UserRepository,
) : IUserService {
    @Throws(UserAlreadyExistsException::class)
    override fun createUser(user: User): User {
        val foundUser = user.email?.let { repository.findByEmail(it) }

        if (foundUser != null) {
            throw UserAlreadyExistsException("User with email ${user.email} already exists")
        }
        return repository.save(user)
    }

    @Throws(UserNotFoundException::class)
    override fun findByUUID(uuid: Long): User {
        val foundUser = repository.findByUUID(uuid)

        if (foundUser == null)
            throw UserNotFoundException("User with uuid $uuid not found")

        return foundUser
    }

    override fun findAll() : List<User> =
        repository.findAll()

    @Throws(UserNotFoundException::class)
    override fun deleteByUUID(uuid: Long): Boolean {
        if (repository.findByUUID(uuid) == null)
            throw UserNotFoundException("User with uuid $uuid not found")

        return repository.deleteByUUID(uuid)
    }
}

class UserAlreadyExistsException(message: String) : RuntimeException(message)

class UserNotFoundException(message: String) : RuntimeException(message)

@ControllerAdvice
class UserExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleUserAlreadyExistsException(ex: UserAlreadyExistsException): String {
        return ex.message ?: "User already exists"
    }

    @ExceptionHandler(UserNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleUserNotFoundException(ex: UserNotFoundException): String {
        return ex.message ?: "User not found"
    }
}