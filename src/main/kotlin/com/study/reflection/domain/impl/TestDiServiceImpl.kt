package com.study.reflection.domain.impl

import com.study.reflection.common.EventCode
import com.study.reflection.common.ServiceVersion
import com.study.reflection.common.SpecificActionItem
import com.study.reflection.domain.TestDiService
import com.study.reflection.domain.TestEventService
import com.study.reflection.domain.TestService
import com.study.reflection.domain.TestSpecificFunService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils
import java.util.*

@Service
class TestDiServiceImpl : TestDiService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    lateinit var applicationContext: ApplicationContext

    override fun getTestService(version: String): TestService {
        return applicationContext.getBeanProvider(TestService::class.java).stream()
            .filter { b -> !ObjectUtils.isEmpty(b.javaClass.getDeclaredAnnotation(ServiceVersion::class.java)) }
            .filter { b ->
                Arrays.stream(b.javaClass.getDeclaredAnnotation(ServiceVersion::class.java).values)
                    .anyMatch { v -> v.equals(version) }
            }
            .findAny()
            .orElse(applicationContext.getBean("TestServiceV1Impl", TestService::class.java))
    }

    override fun invokeServiceFun(so: String, actionItem: String, param: Map<*, *>): Any? {
        if (so.isNullOrEmpty() || actionItem.isNullOrEmpty()) {
            logger.info("[DI LOG] invoke func so or actionItem is Empty -> { so : $so, actionItem : $actionItem }")
            return null
        }

        var invokeResult: Any? = null
        applicationContext.getBeanProvider(TestSpecificFunService::class.java).stream()
            .forEach extraClass@{ clazz ->
                clazz.javaClass.declaredMethods.forEach extraMethod@{ method ->
                    val extraMethod = method.getAnnotation(SpecificActionItem::class.java)
                    if (!ObjectUtils.isEmpty(extraMethod)) {
                        if (extraMethod.soIds.contains(so) && extraMethod.actionItem.contains(actionItem)) {
                            invokeResult = clazz.javaClass.getMethod(method.name, Map::class.java).invoke(clazz, param)
                            return@extraClass
                        }
                    } else {
                        return@extraClass
                    }
                }
            }

        return invokeResult
    }

    override fun invokeEventFun(eventCode: Int, param: Map<*, *>): Any? {
        if (param.isEmpty()) {
            logger.info("[DI LOG] invoke func param is Empty -> { eventCode : $eventCode, param : $param }")
            return null
        }

        var invokeResult: Any? = null
        applicationContext.getBeanProvider(TestEventService::class.java).stream()
            .forEach eventClass@{ clazz ->
                clazz.javaClass.declaredMethods.forEach eventMethod@{ method ->
                    val extraMethod = method.getAnnotation(EventCode::class.java)
                    if (!ObjectUtils.isEmpty(extraMethod)) {
                        if (extraMethod.values.contains(eventCode)) {
                            invokeResult = clazz.javaClass.getMethod(method.name, Map::class.java).invoke(clazz, param)
                            return@eventClass
                        }
                    } else {
                        return@eventClass
                    }
                }
            }

        return invokeResult
    }
}