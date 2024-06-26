package com.example.demo.controller;

import com.example.demo.models.Cliente;
import com.example.demo.models.Pizza;
import com.example.demo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
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
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente novoCliente) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        Cliente cliente = optionalCliente.get();
        cliente.setNome(novoCliente.getNome());
        // Atualizar outros atributos conforme necessário

        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id){
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isEmpty()){
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.delete(optionalCliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }
}
