package com.study.reflection

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReflectionApplication

fun main(args: Array<String>) {
	runApplication<ReflectionApplication>(*args)
}
