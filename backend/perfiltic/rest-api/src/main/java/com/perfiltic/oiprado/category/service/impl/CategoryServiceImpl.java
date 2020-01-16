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
    public List<com.perfiltic.oiprado.category.dto.Category> getCategories() {

//        Iterable<Category> source = categoryRepository.getCategoriesWhenParentNull();
//        List<Category> target = new ArrayList<>();
//        source.forEach(target::add);
        List<Category> parents = categoryRepository.getCategoriesWhenParentNull();

        List<com.perfiltic.oiprado.category.dto.Category> tmpCategories = new ArrayList<>();

        for (Category parent : parents) {
            com.perfiltic.oiprado.category.dto.Category tmpCategory = new com.perfiltic.oiprado.category.dto.Category(
                parent.getId(),
                parent.getName()
            );

            tmpCategories.add(tmpCategory);

            exploreChilds(parent.getCategoryList(), tmpCategory);
        }

        return tmpCategories;
    }

    private void exploreChilds(List<Category> categories, com.perfiltic.oiprado.category.dto.Category tmpCategory) {

        if (categories == null) {
            return;
        }

        for (Category category : categories) {
            com.perfiltic.oiprado.category.dto.Category parent = new com.perfiltic.oiprado.category.dto.Category(
                category.getId(),
                category.getName()
            );
            tmpCategory.getCategories().add(parent);
            exploreChilds(category.getCategoryList(), parent);
        }

    }

}
