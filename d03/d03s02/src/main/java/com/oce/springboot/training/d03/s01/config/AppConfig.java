package com.oce.springboot.training.d03.s01.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@ComponentScan(basePackages = "com.oce.springboot.training.d03.s01")
@EnableJdbcHttpSession
public class AppConfig {
}
