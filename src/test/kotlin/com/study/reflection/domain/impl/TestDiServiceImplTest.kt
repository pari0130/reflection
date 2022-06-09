package com.study.reflection.domain.impl

import com.study.reflection.ReflectionApplication
import com.study.reflection.domain.TestDiService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = arrayOf(ReflectionApplication::class))
internal class TestDiServiceImplTest @Autowired constructor(
    private val testDiService : TestDiService
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Test
    fun getTestService() {
        var version = "v1"
        val itemV1 = testDiService.getTestService(version).getTestItems("v1 item test")

        version = "v1.1"
        val itemV11 = testDiService.getTestService(version).getTestItems("v1.1 item test")

        version = "v1.2"
        val itemV12 = testDiService.getTestService(version).getTestItems("v1.2 item test")

        logger.info("[TEST] item -> { $itemV1, $itemV11, $itemV12 }")
    }

    @Test
    fun invokeServiceFun() {
        var so = "carplat"
        val actionItem = "insert_charge"
        val param = mapOf("param1" to 1, "param2" to 2)

        testDiService.invokeServiceFun(so, actionItem, param)

        so = "peopleCar"
        testDiService.invokeServiceFun(so, actionItem, param)

        so = "way"
        testDiService.invokeServiceFun(so, actionItem, param)
    }

    @Test
    fun invokeEventFun() {
        var eventCode = 10001
        val param = mapOf("param1" to 1, "param2" to 2)

        testDiService.invokeEventFun(eventCode, param)

        eventCode = 10002
        testDiService.invokeEventFun(eventCode, param)

        eventCode = 10003
        testDiService.invokeEventFun(eventCode, param)
    }
}