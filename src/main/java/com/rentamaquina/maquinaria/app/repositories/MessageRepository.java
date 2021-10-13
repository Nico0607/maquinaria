/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories;

import com.rentamaquina.maquinaria.app.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author Usuario
 */
public interface MessageRepository extends JpaRepository<Message,Integer> {
    
}
