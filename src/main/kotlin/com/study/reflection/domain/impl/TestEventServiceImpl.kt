package com.study.reflection.domain.impl

import com.study.reflection.common.EventCode
import com.study.reflection.domain.TestEventService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TestEventServiceImpl : TestEventService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @EventCode(values = [10001])
    override fun insertChargeEvent(param: Map<String, Any>) {
        logger.info("insertChargeEvent -> { eventCode : 10001, param : $param }")
    }

    @EventCode(values = [10002])
    override fun insertBookingEvent(param: Map<String, Any>) {
        logger.info("insertBookingEvent -> { eventCode : 10002, param : $param }")
    }

    @EventCode(values = [10003])
    override fun insertUserEvent(param: Map<String, Any>) {
        logger.info("insertUserEvent -> { eventCode : 10003, param : $param }")
    }
}