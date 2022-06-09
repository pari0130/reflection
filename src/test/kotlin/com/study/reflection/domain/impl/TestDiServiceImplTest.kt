package com.study.reflection.domain.impl

import com.study.reflection.ReflectionApplication
import com.study.reflection.domain.TestDiService
import com.study.reflection.domain.TestEventService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.TimeUnit
import kotlin.math.log
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

@SpringBootTest(classes = arrayOf(ReflectionApplication::class))
internal class TestDiServiceImplTest @Autowired constructor(
    private val testDiService : TestDiService,
    private val testEventService: TestEventService
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

        Assertions.assertEquals(itemV1["item"], "v1 item test")
        Assertions.assertEquals(itemV11["item"], "v1.1 item test")
        Assertions.assertEquals(itemV12["item"], "v1.2 item test")
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

    @Test
    fun `성능측정`(){
        val reflectionTime = measureNanoTime {
            val eventCode = 10001
            val param = mapOf("param1" to 1, "param2" to 2)
            for (i in 0..1000) {
                testDiService.invokeEventFun(eventCode, param)
            }
        }

        val reflectionTimeOne = measureNanoTime {
            val eventCode = 10001
            val param = mapOf("param1" to 1, "param2" to 2)
            testDiService.invokeEventFun(eventCode, param)
        }

        val directTime = measureNanoTime {
            for (i in 0..1000) {
                testEventService.insertBookingEvent(mapOf("param1" to 1, "param2" to 2))
            }
        }

        val directTimeOne = measureNanoTime {
            testEventService.insertBookingEvent(mapOf("param1" to 1, "param2" to 2))
        }


        // 1 나노초 = 1.0×10^9 초, 25766916 -> 0.025, 24791 -> 0.000024791

        // 1000회 반복 시간 -> { reflectionTime : 32601042, directTime : 15015167 }
        logger.info("1000회 반복 시간 -> { reflectionTime : $reflectionTime, directTime : $directTime }")

        // 1회 시간 -> { reflectionTimeOne : 23958, directTimeOne : 5083 }
        logger.info("1회 시간 -> { reflectionTimeOne : $reflectionTimeOne, directTimeOne : $directTimeOne }")
    }
}