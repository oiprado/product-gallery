/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.product.service.impl;

import com.perfiltic.oiprado.category.domain.Category;
import com.perfiltic.oiprado.product.domain.Product;
import com.perfiltic.oiprado.product.repository.ProductRepository;
import com.perfiltic.oiprado.product.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 *
 * @author oiprado
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(Map<String, String> parameters, Pageable pageable) {

        Specification<Product> specification = (Root<Product> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            if(parameters.containsKey("category")) {
                Join<Product, Category> categories = root.join("categoryId");
                predicates.add(cb.equal(categories.get("id"), parameters.get("category")));
            }
            
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        Iterable<Product> source = productRepository.findAll(specification, pageable);
        List<Product> target = new ArrayList<>();

        source.forEach(target::add);

        return target;
    }

}
