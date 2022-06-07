package com.study.reflection.domain.impl

import com.study.reflection.common.SpecificActionItem
import com.study.reflection.domain.TestSpecificFunService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class TestSpecificFunServiceImpl : TestSpecificFunService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @SpecificActionItem(soIds = ["carplat"], actionItem = ["insert_charge"])
    override fun insertChargeByCarplat(param: Map<String, Any>) {
        logger.info("insertCharge -> { so : carplat, item : insert_charge, param : $param }")
    }

    @SpecificActionItem(soIds = ["peopleCar"], actionItem = ["insert_charge"])
    override fun insertChargeByPeopleCar(param: Map<String, Any>) {
        logger.info("insertCharge -> { so : peopleCar, item : insert_charge, param : $param }")
    }

    @SpecificActionItem(soIds = ["way"], actionItem = ["insert_charge"])
    override fun insertChargeByWay(param: Map<String, Any>) {
        logger.info("insertCharge -> { so : way, item : insert_charge, param : $param }")
    }
}