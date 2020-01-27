package com.products.financialcontrol.usermanager.usermanager.repositories

import com.products.financialcontrol.usermanager.usermanager.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {

    fun findUserByEmail(email: String): User

}