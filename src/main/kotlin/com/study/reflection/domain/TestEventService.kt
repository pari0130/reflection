package com.study.reflection.domain

interface TestEventService {
    fun insertChargeEvent(param: Map<String, Any>)
    fun insertBookingEvent(param: Map<String, Any>)
    fun insertUserEvent(param: Map<String, Any>)
}