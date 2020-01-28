package com.products.financialcontrol.useraccount.model

import javax.persistence.*

@Entity
@Table(name = "user_account")
data class UserAccountEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        val userId: Long
)