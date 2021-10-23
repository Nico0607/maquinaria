/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Category;
import com.rentamaquina.maquinaria.app.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    
    @Autowired
    private CategoryService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Category> getCategorys(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param category
     * @return 
     */
    @PostMapping("/save")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return service.save(category);
    }*/
    public ResponseEntity save(@RequestBody Category category){
        service.save(category);
        return ResponseEntity.status(201).build();
    }
    /**
     * PUT
     * @param category
     * @return 
     */
    @PutMapping("/update")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return service.update(category);
    }*/
    public ResponseEntity update(@RequestBody Category category){
        service.update(category);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Delete
     * @param categoryId
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /*public boolean delete(@PathVariable("id") int categoryId){
        return service.deleteCategory(categoryId);
    }*/
    public boolean delet(@PathVariable("id") int categoryId){
        return service.deleteCategory(categoryId);
    }
    
}
