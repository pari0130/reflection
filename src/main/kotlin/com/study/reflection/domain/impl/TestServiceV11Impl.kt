package com.study.reflection.domain.impl

import com.study.reflection.common.ServiceVersion
import com.study.reflection.domain.TestDiService
import com.study.reflection.domain.TestService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service("TestServiceV11Impl")
@ServiceVersion(values = ["v1.1"])
class TestServiceV11Impl(val testDiService: TestDiService) : TestService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun getTestItems(item: String): Map<String, Any> {
        logger.info("item v1.1 -> { item : $item }")
        return mapOf("item" to item)
    }

    override fun insertCharge(param: Map<String, Any>) {
        logger.info("insertCharge v11 -> { param : $param }")
        testDiService.invokeServiceFun("paopleCar", "insert_charge", mapOf("so" to "paopleCar", "item" to "charge"))
    }
}