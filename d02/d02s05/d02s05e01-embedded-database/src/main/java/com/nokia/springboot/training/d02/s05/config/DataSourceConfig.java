package com.nokia.springboot.training.d02.s05.config;

import com.nokia.springboot.training.d02.s05.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Collections;

/**
 * A simple {@link javax.sql.DataSource} configuration, which:
 * <ul>
 *     <li>configures the JPA repositories, using the {@link EnableJpaRepositories} annotation</li>
 *     <li>inserts a simple {@link Product} in the auto-wired [in-memory] database</li>
 * </ul>
 */
//@Configuration
@EnableJpaRepositories(
        basePackages = "com.nokia.springboot.training.d02.s05.repository",
        entityManagerFactoryRef = "entityManagerFactory"
)
@EnableTransactionManagement
public class DataSourceConfig {

    private final DataSource dataSource;

    @Autowired
    public DataSourceConfig(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public HibernateTemplate hibernateTemplate() {
        final HibernateTemplate hibernateTemplate = new HibernateTemplate(null);

        return hibernateTemplate;
    }

    @Profile("PROD")
    @Bean
    public CacheManager cacheManager() {
        final SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        Cache cache = new ConcurrentMapCache("products");
        simpleCacheManager.setCaches(Collections.singleton(cache));

        return simpleCacheManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf =  new LocalContainerEntityManagerFactoryBean();

        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPersistenceUnitName("default");
        emf.setPackagesToScan("com.nokia.springboot.training.d02.s05.repository");

        return emf;
    }
}
