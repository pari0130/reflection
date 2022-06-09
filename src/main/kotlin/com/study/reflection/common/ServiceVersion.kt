package com.study.reflection.common

/**
 * 설명
 *
 * Retention RunTime : compile time 과 binary 에도 포함되고, reflection 을 통해 접근 가능합니다.
 *
 * Target CLASS : class, interface, object, annotation class 에 사용 가능하도록 제한
 *
 * values : 서비스 버전 정보 입력을 위해 사용
 *
 * */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
annotation class ServiceVersion(
    val values: Array<String> = []
)