/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.repositories.ClientRepository;
import com.rentamaquina.maquinaria.app.repositories.ClientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    
    /**
     * GET Consultar todos los Registros.
     * @return 
     */
    public List<Client> getClients(){
        return repository.findAll();
    }
    
    /**POST Crear o Registrar
     * @param Client
     * @return 
     */
    public Client saveClient(Client client){
        Client existingClient = repository.findById(client.getId()).orElse(null);
        if(existingClient==null){
            repository.save(client);
        }
        return repository.save(client);
    }
    
    /**
     *PUT Actualizar o Editar
     * @param Client
     * @return 
     */
    public Client updateClient(Client client){
        Client existingClient = repository.findById(client.getId()).orElse(null);
        existingClient.setName(client.getName());
        existingClient.setEmail(client.getEmail());
        existingClient.setAge(client.getAge());
        return  repository.save(existingClient);
    }
    
    public String deleteClient(int id){
        repository.deleteById(id);
        return "Cliente eliminado" + id;
    }
}
