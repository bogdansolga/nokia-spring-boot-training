package com.nokia.springboot.training.d04.s04.controller;

import com.nokia.springboot.training.d04.s04.service.ProductService;
import com.nokia.springboot.training.d04.s04.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * A Spring {@link RestController}
 *
 * @author bogdan.solga
 */
@RestController
@RequestMapping(
        path = "/product"
)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public ProductDTO getProduct(@PathVariable final int id) {
        return productService.get(id);
    }
}
