package com.example.demo.controller;

import com.example.demo.models.Cliente;
import com.example.demo.models.Pizza;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Cliente> criarCliente (@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> mostrarClientes (){
        List<Cliente>cliente = clienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> mostrarClientePorId(@PathVariable Long id ){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteDb ) {
        Optional<Cliente> clieteDb = clienteRepository.findById(id);
        if (clieteDb.isEmpty()) {
            throw new RuntimeException("Cliente não encontrada");
        }
        clieteDb.get().setNome(clienteDb.getNome());


        clienteRepository.save(clienteDb.get());
        return ResponseEntity.status(HttpStatus.OK).body(clienteDb.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPizza(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isEmpty()){
            throw new RuntimeException("Pizza não encontrada");
        }
        clienteRepository.delete(cliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pizza deletada com sucesso");
    }
}
