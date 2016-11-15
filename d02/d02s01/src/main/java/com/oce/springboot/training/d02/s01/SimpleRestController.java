package com.oce.springboot.training.d02.s01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

    @RequestMapping(
            value = "/hello"
    )
    public String hello() {
        return "Hello, Spring Boot!";
    }
}
