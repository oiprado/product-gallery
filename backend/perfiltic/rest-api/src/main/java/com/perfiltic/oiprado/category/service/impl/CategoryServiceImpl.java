/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.category.service.impl;

import com.perfiltic.oiprado.category.domain.Category;
import com.perfiltic.oiprado.category.repository.CategoryRepository;
import com.perfiltic.oiprado.category.service.CategoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author oiprado
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List getCategories() {
        
        Iterable<Category> source = categoryRepository.findAll();
        List<Category> target = new ArrayList<>();
        source.forEach(target::add);

        return target;
    }
    
}
