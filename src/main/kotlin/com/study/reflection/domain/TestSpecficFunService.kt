package com.study.reflection.domain

interface TestSpecificFunService {
    fun insertChargeByCarplat(param: Map<String, Any>)
    fun insertChargeByPeopleCar(param: Map<String, Any>)
    fun insertChargeByWay(param: Map<String, Any>)
}