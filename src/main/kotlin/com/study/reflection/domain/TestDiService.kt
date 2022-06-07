package com.study.reflection.domain

interface TestDiService {
    fun getTestService(version: String): TestService
    fun invokeServiceFun(so: String, actionItem: String, param: Map<*, *>): Any?
    fun invokeEventFun(eventCode: Int, param: Map<*, *>): Any?
}