package com.study.reflection.common

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class SpecificActionItem(
    val soIds: Array<String> = [],
    val actionItem: Array<String> = []
)