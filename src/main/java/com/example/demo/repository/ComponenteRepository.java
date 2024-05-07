/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Componente;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ComponenteRepository extends JpaRepository<Componente, Integer> {

}

