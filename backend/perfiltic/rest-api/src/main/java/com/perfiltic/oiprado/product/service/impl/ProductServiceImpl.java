/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.product.service.impl;

import com.perfiltic.oiprado.product.domain.Product;
import com.perfiltic.oiprado.product.repository.ProductRepository;
import com.perfiltic.oiprado.product.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oiprado
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getProducts() {
        Iterable<Product> source = productRepository.findAll();
        List<Product> target = new ArrayList<>();
        
        source.forEach(target::add);
        
        return target;
    }
    
}
