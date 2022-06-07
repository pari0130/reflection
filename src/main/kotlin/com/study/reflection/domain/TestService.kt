package com.study.reflection.domain

interface TestService {
    fun getTestItems(item: String): Map<String, Any>
    fun insertCharge(param: Map<String, Any>)
}