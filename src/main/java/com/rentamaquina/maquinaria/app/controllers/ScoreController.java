/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;

import com.rentamaquina.maquinaria.app.entities.Score;
import com.rentamaquina.maquinaria.app.services.ScoreService;
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
@RequestMapping("Score")
public class ScoreController {
    
    @Autowired
    private ScoreService service;
    
    /**
     * GET
     * @return 
     */
    @GetMapping("/all")
    public List<Score> getScores(){
        return service.getAll();
    }
    
    /**
     * POST
     * @param score
     * @return 
     */
    @PostMapping("/save")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return service.save(score);
    }*/
    public ResponseEntity save(@RequestBody Score score){
        service.save(score);
        return ResponseEntity.status(201).build();
    }
    /**
     * PUT
     * @param score
     * @return 
     */
    @PutMapping("/update")
    /*@ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score){
        return service.update(score);
    }*/
    public ResponseEntity update(@RequestBody Score score){
        service.update(score);
        return ResponseEntity.status(201).build();
    }
    
    /**
     * Delete
     * @param scoreId
     * @return 
     */
    /*@DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int scoreId){
        return service.deleteScore(scoreId);
    }*/
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int scoreId){
        return service.deleteScore(scoreId);
    }
    /*@Autowired
    private ScoreService service;
    
    @GetMapping("/all")
    public List<Score> findAllScore(){
        return service.getCategories();
    }
    
    @PostMapping("/save")
    public ResponseEntity addScore(@RequestBody Score score){
        service.saveScore(score);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/update")
    public ResponseEntity updateScore(@RequestBody Score score){
        service.updateScore(score);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity deleteScore(@RequestBody Score score){
        service.deleteScore(score.getId());
        return ResponseEntity.status(204).build();
    }*/
}
