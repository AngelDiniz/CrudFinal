package com.example.demo.controller;

import com.example.demo.models.Bebida;
import com.example.demo.models.Pizza;
import com.example.demo.repositories.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {
    @Autowired
    private BebidaRepository bebidaRepository;
    @PostMapping
    public ResponseEntity<Bebida> criarBebida(@RequestBody Bebida bebida ){
        bebidaRepository.save(bebida);
        return ResponseEntity.status(HttpStatus.CREATED).body(bebida);

    }

    @GetMapping
    public ResponseEntity<List<Bebida>> mostrarBebida(){
        List<Bebida> bebidas = bebidaRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(bebidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> mostrarBebidasPorId(@PathVariable Long id ){
        Optional<Bebida> bebida = bebidaRepository.findById(id);
        if (bebida.isEmpty()){
            throw new RuntimeException("Bebida não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bebida.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Bebida> atualizarBebida (@PathVariable Long id, @RequestBody Bebida bebida) {
        Optional<Bebida> bebidaa = bebidaRepository.findById(id);
        if (bebidaa.isEmpty()) {
            throw new RuntimeException("Bebida não encontrada");
        }
        bebidaa.get().setNome(bebida.getNome());


        bebidaRepository.save(bebida.get());
        return ResponseEntity.status(HttpStatus.OK).body(bebida.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBebida(@PathVariable Long id){
        Optional<Bebida> bebida = bebidaRepository.findById(id);
        if (bebida.isEmpty()){
            throw new RuntimeException("Bebida não encontrada");
        }
        bebidaRepository.delete(bebida.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pizza deletada com sucesso");
    }

}
