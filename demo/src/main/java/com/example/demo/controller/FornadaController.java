package com.example.demo.controller;

import com.example.demo.models.Fornada;
import com.example.demo.models.Pizza;
import com.example.demo.repositories.FornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/fornada")
@RestController

public class FornadaController {
    @Autowired
    private FornadaRepository fornadaRepository;

    @PostMapping
    public ResponseEntity<Fornada> criarFornada (@RequestBody Fornada fornada ){
        fornadaRepository.save(fornada);
        return ResponseEntity.status(HttpStatus.CREATED).body(fornada);

    }

    @GetMapping
    public ResponseEntity<List<Fornada>> mostrarFornada (){
        List<Fornada> fornada = fornadaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(fornada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornada> mostrarFornadaporID (@PathVariable Long id ){
        Optional<Fornada> fornada = fornadaRepository.findById(id);
        if (fornada.isEmpty()){
            throw new RuntimeException("Pizza não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(fornada.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Fornada> atualizarFornada(@PathVariable Long id, @RequestBody Pizza pizza) {
        Optional<Fornada> fornadaDb = fornadaRepository.findById(id);
        if (fornadaDb.isEmpty()) {
            throw new RuntimeException("Pizza não encontrada");
        }
        fornadaDb.get().setNumFornada(fornadaDb.get().getNumFornada());


        fornadaRepository.save(fornadaDb.get());
        return ResponseEntity.status(HttpStatus.OK).body(fornadaDb.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFornada(@PathVariable Long id){
        Optional<Fornada> fornada = fornadaRepository.findById(id);
        if (fornada.isEmpty()){
            throw new RuntimeException("Fornada não encontrada");
        }
        fornadaRepository.delete(fornada.get());
        return ResponseEntity.status(HttpStatus.OK).body("Fornada deletada com sucesso");
    }
}
