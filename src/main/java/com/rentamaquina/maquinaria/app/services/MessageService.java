/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Message;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentamaquina.maquinaria.app.repositories.MessageRepository;
import java.util.Optional;




/**
 *
 * @author Usuario
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Message> getAll(){
        return repository.getAll();
    }
    
    /**
     * buscar
     * @param messageId
     * @return 
     */
    public Optional<Message> getMessage(int messageId){
        return repository.getMessage(messageId);
    }
    
    /**
     * POST
     * @param message
     * @return 
     */
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return repository.save(message);
        }else{
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                return message;
            }else{
                return repository.save(message);
            }
        }
    }
    
    /**
     * Update
     * @param message
     * @return 
     */
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> resultado = repository.getMessage(message.getIdMessage());
            if(resultado.isPresent()){
                if(message.getMessageText()!=null){
                    resultado.get().setMessageText(message.getMessageText());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    
    /**
     * Delete
     * @param messageId
     * @return 
     */
    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMessage(messageId).map(message -> {
            repository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
