package com.products.financialcontrol.useraccount.service

import com.products.financialcontrol.useraccount.model.UserAccountEntity

interface UserAccountService {

    fun save(userAccountEntity: UserAccountEntity): UserAccountEntity

    fun findByUserId(userId: Long): UserAccountEntity

    fun findById(userId: Long): UserAccountEntity

}