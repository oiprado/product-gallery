/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.category.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oiprado
 */
public class Category {

    private Integer id;
    private String name;
    private List<Category> categories;

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.categories = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
