package com.products.financialcontrol.usermanager.usermanager.model

import com.products.financialcontrol.usermanager.usermanager.controllers.dto.UserDto
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        val email: String,
        val password: String,
        var dateRegister: LocalDateTime?) {

    fun toDto() = UserDto(this.id!!, this.email, this.dateRegister!!)
}