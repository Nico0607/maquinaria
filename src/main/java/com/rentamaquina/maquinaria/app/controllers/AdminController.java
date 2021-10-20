/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Admin;
import com.rentamaquina.maquinaria.app.services.AdminService;
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
@RequestMapping("Admin")
public class AdminController {
    
    @Autowired
    private AdminService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param admin
     * @return 
     */
    @PostMapping("/save")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return service.save(admin);
    }*/
    public ResponseEntity save(@RequestBody Admin admin){
        service.save(admin);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * PUT
     * @param admin
     * @return 
     */
    @PutMapping("/update")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){
        return service.update(admin);
    }*/
    public ResponseEntity update(@RequestBody Admin admin){
        service.update(admin);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Delete
     * @param adminId
     * @return 
     */
    /*@DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int adminId){
        return service.deleteAdmin(adminId);
    }*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminId){
        return service.deleteAdmin(adminId);
    }
    
            
 }
