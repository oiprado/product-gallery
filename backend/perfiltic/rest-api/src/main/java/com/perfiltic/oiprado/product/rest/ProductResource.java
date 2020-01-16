/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.product.rest;

import com.perfiltic.oiprado.product.domain.Product;
import com.perfiltic.oiprado.product.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author oiprado
 */
@RestController
@RequestMapping("/api/product-managment")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts(@RequestParam Map<String, String> parameters) {

        Pageable pageable;
        try {

            int page = parameters.containsKey("page") ? Integer.parseInt(parameters.get("page")) : 0;
            int size = parameters.containsKey("size") ? Integer.parseInt(parameters.get("size")) : 0;
            String sort = parameters.containsKey("sort") ? parameters.get("sort") : null;

            Sort sortClause = null;
            if (sort != null) {
                if (parameters.containsKey("direction") && parameters.get("direction").equals("desc")) {
                    sortClause = Sort.by(sort).descending();
                } else {
                    sortClause = Sort.by(sort).ascending();
                }
            }

            if (sortClause != null) {
                pageable = PageRequest.of(page, size, sortClause);
            } else {
                pageable = PageRequest.of(page, size);
            }

        } catch (NumberFormatException ex) {
            pageable = PageRequest.of(0, 0);
        }
        return productService.getProducts(parameters, pageable);
    }

}
