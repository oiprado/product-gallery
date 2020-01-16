/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.category.repository;

import com.perfiltic.oiprado.category.domain.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oiprado
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer>{

    @Query("SELECT c FROM Category c where c.parentId is null")
    public List<Category> getCategoriesWhenParentNull();
    
    @Query("SELECT c FROM Category c where c.parentId.id = :id")
    public List<Category> getCategoresByParentId();
    
}
