package com.study.reflection.common

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class ServiceVersion(
    val values: Array<String> = []
)