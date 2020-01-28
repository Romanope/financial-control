package com.products.financialcontrol.useraccount.controller.dto

import com.products.financialcontrol.useraccount.model.UserAccountEntity

class UserAccountDto(val accountId: Long,
                     val userId: Long) {
    constructor(userAccountEntity: UserAccountEntity) :
            this(userAccountEntity.id!!, userAccountEntity.userId)
}