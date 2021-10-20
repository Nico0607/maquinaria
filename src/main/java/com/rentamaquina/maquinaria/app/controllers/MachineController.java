/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.services.MachineService;
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

/*
import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.services.MachineService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
*/
/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("Machine")
public class MachineController {
    
    
    @Autowired
    private MachineService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Machine> getMachines(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param machine
     * @return 
     */
    @PostMapping("/save")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine){
        return service.save(machine);
    }*/
    public ResponseEntity save(@RequestBody Machine machine){
        service.save(machine);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * PUT
     * @param machine
     * @return 
     */
    @PutMapping("/update")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine){
        return service.update(machine);
    }*/
    public ResponseEntity update(@RequestBody Machine machine){
        service.update(machine);
        return ResponseEntity.status(201).build();
    }
    /**
     * Delete
     * @param machineId
     * @return 
     */
    /*@DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int machineId){
        return service.deleteMachine(machineId);
    }*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId){
        return service.deleteMachine(machineId);
    }
    /*@Autowired
    private MachineService service;
    
    @GetMapping("/all")
    public List<Machine> findAllMachine(){
        return service.getMachines();
    }
    
    @PostMapping("/save")
    public ResponseEntity addMachine(@RequestBody Machine machine){
        service.saveMachine(machine);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateMachine(@RequestBody Machine machine){
        service.saveMachine(machine);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteMachine(@RequestBody Machine machine){
        service.deleteMachine(machine.getId());
        return ResponseEntity.status(204).build();
    }*/
}
