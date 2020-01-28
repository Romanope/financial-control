package com.products.financialcontrol.useraccount.model

import com.products.financialcontrol.useraccount.enum.MovementTypeEnum
import javax.persistence.*

@Entity
@Table(name = "income_expense")
data class IncomeExpenseEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        val name: String,
        val movementType: MovementTypeEnum,

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_account_id")
        val userAccount: UserAccountEntity)