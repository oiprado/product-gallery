/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.product.service;

import com.perfiltic.oiprado.product.domain.Product;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author oiprado
 */
public interface ProductService {

    public List<Product> getProducts(Map<String, String> parameters, Pageable pageable);

    public Product create(com.perfiltic.oiprado.product.dto.Product product);
}
