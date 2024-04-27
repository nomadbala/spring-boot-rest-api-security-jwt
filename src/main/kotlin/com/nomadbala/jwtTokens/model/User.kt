package com.nomadbala.jwtTokens.model

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.RequiredArgsConstructor

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
open class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    open var id: Long = 0

    @Column(name = "email")
    open var email: String = ""

    @Column(name = "password")
    open var password: String = ""

    @Column(name = "role")
    open var role: Role = Role.USER

    constructor(id: Long, email: String, password: String, role: Role) {
        this.id = id;
        this.email = email
        this.password = password
        this.role = role
    }
}

enum class Role {
    USER,
    ADMIN
}
