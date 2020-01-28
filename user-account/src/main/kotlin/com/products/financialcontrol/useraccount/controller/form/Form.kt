package com.products.financialcontrol.useraccount.controller.form

interface Form<T> {

    fun toEntity(): T
}