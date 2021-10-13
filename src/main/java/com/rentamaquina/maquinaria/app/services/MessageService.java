/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.repositories.MessageRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author Usuario
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;
    
    /**
     * GET Consultar todos los Registros.
     * @return 
     */
    public List<Message> getMessages(){
        return repository.findAll();
    }
    
    /**POST Crear o Registrar
     * @param Message
     * @return 
     */
    public Message saveClient(Message message){
        /*Message existingMessage = repository.findById(message.getId()).orElse(null);
        if(existingMessage==null){
            repository.save(message);
        }*/
        return repository.save(message);
    }
    
    /**
     *PUT Actualizar o Editar
     * @param Message
     * @return 
     */
    public Message updateMessage(Message message){
        /*Message existingMessage;
        existingMessage = repository.findById(message.getId()).orElse(null);
        existingMessage.setMessage(message.getMessage());*/
        return null;
    }
    
    public String deleteMessage(int id){
        repository.deleteById(id);
        return "Mensaje eliminado" + id;
    }

    public void saveMessage(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
