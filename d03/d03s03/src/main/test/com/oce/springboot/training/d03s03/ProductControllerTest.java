package com.oce.springboot.training.d03s03;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.filter.log.LogDetail;
import com.oce.springboot.training.d03s03.model.Product;
import com.oce.springboot.training.d03s03.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;

@SpringBootTest(
        classes = ProductServiceDemo.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("default")
public class ProductControllerTest extends AbstractTransactionalTestNGSpringContextTests {

    private static final String PRODUCT_NAME = "Something";

    @LocalServerPort
    private int port;

    @Autowired
    private ProductService productService;

    @BeforeMethod
    public void init() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL);
    }

    @BeforeClass
    public void initializeProduct() {
        final Product product = new Product();
        product.setName(PRODUCT_NAME);
        productService.saveProduct(product);
    }

    @Test
    public void shouldGetAProductById() {
        when()
                .get("/product/{id}", 1)
                .then()
                .statusCode(200)
                .body("name", is(PRODUCT_NAME));
    }

    @Test
    public void shouldGetAllProducts() {
        when()
                .get("/product")
                .then()
                .statusCode(200)
                .body("$.size", is(1))
                .body("[0].name", is(PRODUCT_NAME));
    }
}
