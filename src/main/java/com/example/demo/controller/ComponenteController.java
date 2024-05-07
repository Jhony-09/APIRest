package com.example.demo.controller;

import com.example.demo.model.Componente;
import com.example.demo.repository.ComponenteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/componentes")
@Validated
public class ComponenteController {

    @Autowired
    private  ComponenteRepository componenteRepository;


    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, World!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Componente>> listarComponentes() {
        List<Componente> componentes = componenteRepository.findAll();
        return ResponseEntity.ok(componentes);
    }

    @PostMapping("/crear")
    public ResponseEntity<Componente> crearComponente(@RequestBody @Validated Componente componente) {
        Componente nuevoComponente = componenteRepository.save(componente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComponente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Componente> obtenerComponente(@PathVariable int idComp) {
        Optional<Componente> componenteOptional = componenteRepository.findById(idComp);
        return componenteOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/actualizar")
    public ResponseEntity  actualizarComponente( @RequestBody Componente componente) {
        Componente componenteActualizado = componenteRepository.save(componente);
        return ResponseEntity.ok(componenteActualizado);

    }

    @DeleteMapping("/eliminar")
    public ResponseEntity eliminarComponentes(@RequestParam int idComp) {
        componenteRepository.deleteById(idComp);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el componente");
    }
}
