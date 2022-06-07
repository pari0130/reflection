package com.study.reflection.interfaces

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test")
class TestController {
    @GetMapping(path = ["{id}"])
    fun getTestId(@PathVariable id: String): String? {
        return "[id = " + id + " at " + System.currentTimeMillis() + "]"
    }
}