package com.oce.springboot.training.d03.s01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ProfilingService {

    @Value("${profiling.environment}")
    private String profilingEnvironment;

    @Value("${profiling.connection.timeout}")
    private String profilingConnectionTimeout;

    @Value("${profiling.connection.socket-timeout}")
    private String connectionSocketTimeout;

    @PostConstruct
    public void displayProperties() {
        System.out.println("Profiling environment - " + profilingEnvironment);
        System.out.println("Profiling connection timeout - " + profilingConnectionTimeout);
        System.out.println("Connection socket timeout - " + connectionSocketTimeout);
    }
}
