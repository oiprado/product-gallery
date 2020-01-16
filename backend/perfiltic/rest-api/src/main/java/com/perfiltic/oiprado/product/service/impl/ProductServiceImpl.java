/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.product.service.impl;

import com.perfiltic.oiprado.category.domain.Category;
import com.perfiltic.oiprado.category.repository.CategoryRepository;
import com.perfiltic.oiprado.exception.ActionNotAllowedException;
import com.perfiltic.oiprado.exception.EntityNotFoundException;
import com.perfiltic.oiprado.product.domain.Product;
import com.perfiltic.oiprado.product.domain.ProductPhoto;
import com.perfiltic.oiprado.product.dto.Photo;
import com.perfiltic.oiprado.product.repository.ProductPhotoRepository;
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
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author oiprado
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductPhotoRepository productPhotoRepository;

    @Override
    public List<Product> getProducts(Map<String, String> parameters, Pageable pageable) {

        Specification<Product> specification = (Root<Product> root, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (parameters.containsKey("category")) {
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

    @Transactional
    @Override
    public Product create(com.perfiltic.oiprado.product.dto.Product product) {
        Category category;
        try {
            category = categoryRepository.findById(product.getCategoryId()).get();
        } catch (Exception exception) {
            throw new EntityNotFoundException("Category not found");
        }

        if (!category.getCategoryList().isEmpty()) {
            throw new ActionNotAllowedException("The product can not be created becouse the category has childs");
        }
        
        if(product.getPhotos().isEmpty()) {
            throw new ActionNotAllowedException("The product can not be created becouse does not containt photos");
        }
        
        Product create = new Product();
        create.setCategoryId(category);
        create.setName(product.getName());
        create.setDescription(product.getDescription());
        create.setPrice(product.getPrice());
        
        List<ProductPhoto> productPhotos = new ArrayList<>();
        
        for (Photo photo : product.getPhotos()) {
            
            ProductPhoto productPhoto = new ProductPhoto();
            productPhoto.setImage(photo.getImage());
            productPhoto.setProductId(create);
            
            productPhotos.add(productPhoto);
        }
        
        productRepository.save(create);
        productPhotoRepository.saveAll(productPhotos);
        
        return create;

    }

}
