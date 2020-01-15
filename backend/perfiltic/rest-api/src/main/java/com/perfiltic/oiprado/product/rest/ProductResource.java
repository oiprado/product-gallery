/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.product.rest;

import com.perfiltic.oiprado.product.domain.Product;
import com.perfiltic.oiprado.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oiprado
 */
@RestController
@RequestMapping(path = "/api/product-managment")
public class ProductResource {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    
}
