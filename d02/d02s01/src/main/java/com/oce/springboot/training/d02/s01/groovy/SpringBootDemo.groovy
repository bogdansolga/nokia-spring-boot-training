package com.oce.springboot.training.d02.s01.groovy

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringBootDemo {

    static main(args) {
        SpringApplication.run(SpringBootDemo)
    }

    @RequestMapping("/hello")
    static String hello() {
        "Hello, Spring Boot!"
    }
}