package com.nokia.springboot.training.d02.s05.config;

import com.nokia.springboot.training.d02.s05.model.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * A simple {@link javax.sql.DataSource} configuration, which:
 * <ul>
 *     <li>configures the JPA repositories, using the {@link EnableJpaRepositories} annotation</li>
 *     <li>inserts a simple {@link Product} in the database, using the auto-configured {@link javax.sql.DataSource}</li>
 * </ul>
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.nokia.springboot.training.d02.s05.repository")
public class DataSourceConfig {
}
