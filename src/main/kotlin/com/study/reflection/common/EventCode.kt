package com.study.reflection.common

/**
 * 설명
 *
 * Retention RunTime : compile time 과 binary 에도 포함되고, reflection 을 통해 접근 가능합니다.
 *
 * Target FUNCTION : 생성자를 제외한 함수들에 사용 가능하도록 제한
 *
 * values : Event Code 정보 입력을 위해 사용
 *
 * */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class EventCode(
    val values: IntArray = []
)
