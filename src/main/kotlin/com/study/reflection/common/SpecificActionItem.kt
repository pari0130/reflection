package com.study.reflection.common

/**
 * 설명
 *
 * Retention RunTime : compile time 과 binary 에도 포함되고, reflection 을 통해 접근 가능합니다.
 *
 * Target FUNCTION : 생성자를 제외한 함수들에 사용 가능하도록 제한
 *
 * soIds : so 별 특정 함수 실행 시 so 입력을 위해 사용
 * actionItem : action item 이 다를 수 있으므로 item 입력을 위해 사용
 *
 * */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.FUNCTION)
annotation class SpecificActionItem(
    val soIds: Array<String> = [],
    val actionItem: Array<String> = []
)