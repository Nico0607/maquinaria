/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.repositories.MachineRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.repositories.MachineRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
*/

/**
 *
 * @author Usuario
 */
@Service
public class MachineService {
    
    @Autowired
    private MachineRepository repository;
    
    /**
     * GET Consultar todos los Registros.
     * @return 
     */
    public List<Machine> getMachines(){
        return repository.findAll();
    }
    
    /**POST Crear o Registrar
     * @param machine
     * @return 
     */
    public Machine saveMachine(Machine machine){
        Machine existingMachine = repository.findById(machine.getId()).orElse(null);
        if(existingMachine==null){
            repository.save(machine);
        }
        return repository.save(machine);
    }
    
    /**
     *PUT Actualizar o Editar
     * @param machine
     * @return 
     */
    public Machine updateMachine(Machine machine){
        Machine existingMachine = repository.findById(machine.getId()).orElse(null);
        existingMachine.setName(machine.getName());
        existingMachine.setBrand(machine.getBrand());
        existingMachine.setModel(machine.getModel());
        existingMachine.setCategory_id(machine.getCategory_id());
        return  repository.save(existingMachine);
    }
    
    public String deleteMachine(int id){
        repository.deleteById(id);
        return "Maquina eliminada" + id;
    }
}
