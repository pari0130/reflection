package com.study.reflection.domain.impl

import com.study.reflection.domain.TestDiService
import com.study.reflection.domain.TestService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TestServiceV12Impl(val testDiService: TestDiService) : TestService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun getTestItems(item: String): Map<String, Any> {
        logger.info("item v1 -> { item : $item }")
        return mapOf("item v12" to item)
    }

    override fun insertCharge(param: Map<String, Any>) {
        logger.info("insertCharge v12 -> { param : $param }")
        testDiService.invokeServiceFun("way", "insert_charge", mapOf("so" to "way", "item" to "charge"))
    }
}