package com.products.financialcontrol.useraccount.repository

import com.products.financialcontrol.useraccount.model.UserAccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserAccountRepository : JpaRepository<UserAccountEntity, Long> {

    fun findByUserId(id: Long): UserAccountEntity
}