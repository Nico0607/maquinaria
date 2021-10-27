/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.services.ReservationService;
import com.rentamaquina.maquinaria.app.services.ReservationService;
import custom.CountClient;
import custom.StatusAmount;
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
@RequestMapping("Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    
    @Autowired
    private ReservationService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param reservation
     * @return 
     */
    @PostMapping("/save")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return service.save(reservation);
    }*/
    public ResponseEntity save(@RequestBody Reservation reservation){
        service.save(reservation);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * PUT
     * @param reservation
     * @return 
     */
    @PutMapping("/update")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return service.update(reservation);
    }*/
    public ResponseEntity update(@RequestBody Reservation reservation){
        service.update(reservation);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Delete
     * @param reservationId
     * @return 
     */
    /*@DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int reservationId){
        return service.deleteReservation(reservationId);
    }*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return service.deleteReservation(reservationId);
    }
    
     @GetMapping("/report-status")
    public StatusAmount getPapeleriaDescritionStatus(){
        return service.getStatusReport();
    }
    @GetMapping("/report-clients")
    public List<CountClient> getCountCategoria(){
        return service.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo")String d2){
       return service.getReservationPeriod(d1, d2);
    }
    
}
