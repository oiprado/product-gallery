/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.category.rest;

import com.perfiltic.oiprado.category.domain.Category;
import com.perfiltic.oiprado.category.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oiprado
 */
@RequestMapping("/api/category-managment")
@RestController
public class CategoryResource {
    
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }
    
}
