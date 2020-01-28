package com.products.financialcontrol.useraccount.service

import com.products.financialcontrol.useraccount.model.UserAccountEntity
import com.products.financialcontrol.useraccount.repository.UserAccountRepository
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(val userAccountRepository: UserAccountRepository) : UserAccountService {


    override fun save(userAccountEntity: UserAccountEntity): UserAccountEntity {
        return userAccountRepository.save(userAccountEntity)
    }

    override fun findByUserId(userId: Long): UserAccountEntity {
        return userAccountRepository.findByUserId(userId)
    }

    override fun findById(userId: Long): UserAccountEntity {
        return userAccountRepository.findById(userId).orElseThrow()
    }
}