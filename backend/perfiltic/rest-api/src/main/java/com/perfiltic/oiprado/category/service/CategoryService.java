/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.category.service;

import com.perfiltic.oiprado.category.domain.Category;
import java.util.List;

/**
 *
 * @author oiprado
 */
public interface CategoryService {
    
    public List<com.perfiltic.oiprado.category.dto.Category> getCategories();
    
}
