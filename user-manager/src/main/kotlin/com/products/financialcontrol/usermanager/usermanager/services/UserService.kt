package com.products.financialcontrol.usermanager.usermanager.services

import com.products.financialcontrol.usermanager.usermanager.model.User

interface UserService {

    fun save(user: User): User

    fun update(user: User): User

    fun deleteById(id: Long): Unit

    fun findById(id: Long): User

    fun findUserByEmail(email: String): User
}