package com.study.reflection.common

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class EventCode(
    val values: IntArray = []
)
