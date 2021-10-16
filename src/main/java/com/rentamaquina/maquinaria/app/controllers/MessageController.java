/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.services.MessageService;
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
@RequestMapping("Message")
public class MessageController {
    
    @Autowired
    private MessageService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Message> getMessages(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param message
     * @return 
     */
    @PostMapping("/save")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message){
        return service.save(message);
    }*/
    public ResponseEntity save(@RequestBody Message message){
        service.save(message);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * PUT
     * @param message
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message){
        return service.update(message);
    }
    
    /**
     * Delete
     * @param messageId
     * @return 
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int messageId){
        return service.deleteMessage(messageId);
    }
    /*@Autowired
    private MessageService service;
    
    @GetMapping("/all")
    public List<Message> findAllMessage(){
        return service.getMessages();
    }
    
    @PostMapping("/save")
    public ResponseEntity addMessage(@RequestBody Message message){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateMessage(@RequestBody Message message){
        service.updateMessage(message);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteMessage(@RequestBody Message message){
        service.deleteMessage(message.getIdMessage());
        return ResponseEntity.status(204).build();
    }*/
}
