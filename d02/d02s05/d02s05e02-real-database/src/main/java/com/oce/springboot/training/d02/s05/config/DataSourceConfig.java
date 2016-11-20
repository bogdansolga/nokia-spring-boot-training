package com.oce.springboot.training.d02.s05.config;

import com.oce.springboot.training.d02.s05.model.Product;
import com.oce.springboot.training.d02.s05.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

/**
 * A simple {@link javax.sql.DataSource} configuration, which:
 * <ul>
 *     <li>configures the JPA repositories, using the {@link EnableJpaRepositories} annotation</li>
 *     <li>inserts a simple {@link Product} in the auto-wired [in-memory] database</li>
 * </ul>
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.oce.springboot.training.d02.s05.repository")
public class DataSourceConfig {

    private final ProductService productService;

    @Autowired
    public DataSourceConfig(final ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void init() {
        final Product product = new Product();
        product.setName("A default product");
        productService.create(product);
    }
}
