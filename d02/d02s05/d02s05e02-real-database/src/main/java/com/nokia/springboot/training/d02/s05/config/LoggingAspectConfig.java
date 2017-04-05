package com.nokia.springboot.training.d02.s05.config;

import com.nokia.springboot.training.d02.s05.profiling.Profiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfig {

    @Bean
    public Profiler profiler() {
        return new Profiler();
    }
}
