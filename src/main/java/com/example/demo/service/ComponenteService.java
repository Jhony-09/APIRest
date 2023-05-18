/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.service;

import com.example.demo.model.Componente;
import com.example.demo.repository.ComponenteRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jhony
 */

@Service
public class ComponenteService {
    @Autowired
    private ComponenteRepository componenteRepository;

    public List<Componente> listarComponentes() {
        return componenteRepository.findAll();
    }

    public Componente crearComponente(Componente componente) {
        validarCamposObligatorios(componente);
        validarValores(componente);
        return componenteRepository.save(componente);
    }

    public Componente obtenerComponente(int idComp) {
        return componenteRepository.findById(idComp)
                .orElseThrow(() -> new RuntimeException("Componente no encontrado con ID: " + idComp));
    }

    public Componente actualizarComponente(int idComp, Componente componente) {
        validarCamposObligatorios(componente);
        validarValores(componente);
        componente.setIdComp(idComp);
        return componenteRepository.save(componente);
    }

    public void eliminarComponente(int idComp) {
        componenteRepository.deleteById(idComp);
    }

    private void validarCamposObligatorios(Componente componente) {
        if (componente.getNombreComp().isEmpty() || componente.getDescripcionComp().isEmpty()) {
            throw new RuntimeException("Ingrese el nombre y la descripción del componente");
        }
    }

    private void validarValores(Componente componente) {
        if (componente.getPrecioComp() == null || componente.getPrecioComp().compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Ingrese un precio válido");
        }
    }
}


