/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.product.rest;

import com.perfiltic.oiprado.common.MessageError;
import com.perfiltic.oiprado.product.domain.Product;
import com.perfiltic.oiprado.product.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author oiprado
 */
@RestController
@RequestMapping("/admin/product-managment")
public class AdminProductResource {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody com.perfiltic.oiprado.product.dto.Product product) {
        try {
            return new ResponseEntity(productService.create(product), HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity(new MessageError(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update() {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity delete() {
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
