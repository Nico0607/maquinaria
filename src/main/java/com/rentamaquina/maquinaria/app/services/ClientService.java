/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.entities.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rentamaquina.maquinaria.app.repositories.ClientRepository;
import com.rentamaquina.maquinaria.app.repositories.ClientRepository;
import java.util.Optional;

/**
 *
 * @author Usuario
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository repository;
    
    /**
     * GET
     * @return 
     */
    public List<Client> getAll(){
        return repository.getAll();
    }
    
    /**
     * buscar
     * @param clientId
     * @return 
     */
    public Optional<Client> getClient(int clientId){
        return repository.getClient(clientId);
    }
    
    /**
     * POST
     * @param client
     * @return 
     */
    public Client save(Client client){
        if(client.getIdClient()==null){
            return repository.save(client);
        }else{
            Optional<Client> resultado = repository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                return client;
            }else{
                return repository.save(client);
            }
        }
    }
    
    /**
     * Update
     * @param client
     * @return 
     */
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> resultado = repository.getClient(client.getIdClient());
            if(resultado.isPresent()){
                if(client.getEmail()!=null){
                    resultado.get().setEmail(client.getEmail());
                }if(client.getPassword()!=null){
                    resultado.get().setPassword(client.getPassword());
                }if(client.getName()!=null){
                    resultado.get().setName(client.getName());
                }if(client.getAge()!=null){
                    resultado.get().setAge(client.getAge());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    /**
     * Delete
     * @param clientId
     * @return 
     */
    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
            repository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
