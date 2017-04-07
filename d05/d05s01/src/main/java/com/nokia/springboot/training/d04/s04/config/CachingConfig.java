package com.nokia.springboot.training.d04.s04.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

import static com.nokia.springboot.training.d04.s04.config.CacheNames.PRODUCTS;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public CacheManager cacheManager() {
        final SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        final Cache cache = new ConcurrentMapCache(PRODUCTS);
        simpleCacheManager.setCaches(Collections.singleton(cache));

        return simpleCacheManager;

        //return new ConcurrentMapCacheManager();
    }
}
