package com.example.demo.controller;

import com.example.demo.model.Componente;
import com.example.demo.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/componentes")
@Validated
public class ComponenteController {

    private final ComponenteRepository componenteRepository;

    @Autowired
    public ComponenteController(ComponenteRepository componenteRepository) {
        this.componenteRepository = componenteRepository;
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello, World!");
    }

    @GetMapping
    public ResponseEntity<List<Componente>> listarComponentes() {
        List<Componente> componentes = componenteRepository.findAll();
        return ResponseEntity.ok(componentes);
    }

    @PostMapping
    public ResponseEntity<Componente> crearComponente(@RequestBody @Validated Componente componente) {
        Componente nuevoComponente = componenteRepository.save(componente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoComponente);
    }

    @GetMapping("/{idComp}")
    public ResponseEntity<Componente> obtenerComponente(@PathVariable int idComp) {
        Optional<Componente> componenteOptional = componenteRepository.findById(idComp);
        return componenteOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{idComp}")
    public ResponseEntity<Componente> actualizarComponente(@PathVariable int idComp, @RequestBody @Validated Componente componente) {
        Optional<Componente> componenteOptional = componenteRepository.findById(idComp);
        return componenteOptional
                .map(existingComponente -> {
                    componente.setIdComp(idComp);
                    Componente componenteActualizado = componenteRepository.save(componente);
                    return ResponseEntity.ok(componenteActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping
        public ResponseEntity<Void> eliminarComponentes(@RequestParam("ids") List<Integer> ids) {
        componenteRepository.deleteAllById(ids);
        return ResponseEntity.noContent().build();
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el componente");
    }
}
