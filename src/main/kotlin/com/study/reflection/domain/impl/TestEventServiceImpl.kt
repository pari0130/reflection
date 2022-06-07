package com.study.reflection.domain.impl

import com.study.reflection.common.EventCode
import com.study.reflection.domain.TestEventService
import org.springframework.stereotype.Service

@Service
class TestEventServiceImpl : TestEventService {

    @EventCode(values = [10001])
    override fun insertChargeEvent(param: Map<String, Any>) {
        TODO("Not yet implemented")
    }

    @EventCode(values = [10002])
    override fun insertBookingEvent(param: Map<String, Any>) {
        TODO("Not yet implemented")
    }

    @EventCode(values = [10003])
    override fun insertUserEvent(param: Map<String, Any>) {
        TODO("Not yet implemented")
    }
}