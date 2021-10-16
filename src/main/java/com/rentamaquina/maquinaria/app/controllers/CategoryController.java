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
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
        return service.update(category);
    }
    
    /**
     * Delete
     * @param categoryId
     * @return 
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int categoryId){
        return service.deleteCategory(categoryId);
    }
    /*@Autowired
    private CategoryService service;
    
    @GetMapping("/all")
    public List<Category> findAllCategory(){
        return service.getCategories();
    }
    
    @PostMapping("/save")
    public ResponseEntity addCategory(@RequestBody Category category){
        service.saveCategory(category);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.updateCategory(category);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteCategory(@RequestBody Category category){
        service.deleteCategory(category.getId());
        return ResponseEntity.status(204).build();
    }*/
}