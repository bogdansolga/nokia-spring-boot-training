package com.oce.springboot.training.d03.s01.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * A demo for the usage of a Spring {@link ConfigurationProperties} class
 *
 * @author bogdan.solga
 */
@ConfigurationProperties(prefix = "profiling")
public class ProfilingConfiguration {

    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public static class Connection {
        private int timeout;

        private int socketTimeout;

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        public int getSocketTimeout() {
            return socketTimeout;
        }

        public void setSocketTimeout(int socketTimeout) {
            this.socketTimeout = socketTimeout;
        }
    }
}
