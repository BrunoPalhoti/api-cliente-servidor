package com.git.isadorapalhoti.cliente.controller;

import com.git.isadorapalhoti.cliente.domain.Cliente;
import com.git.isadorapalhoti.cliente.dto.ClientePostRequestBody;
import com.git.isadorapalhoti.cliente.dto.ClientePutRequestBody;
import com.git.isadorapalhoti.cliente.repository.ClienteRepository;
import com.git.isadorapalhoti.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll(){
        return ResponseEntity.ok(clienteService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){
        return ResponseEntity.ok(clienteService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClientePostRequestBody clientePostRequestBody){
        return new ResponseEntity<>(clienteService.save(clientePostRequestBody),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> replace(@PathVariable Integer id, @RequestBody ClientePutRequestBody clientePutRequestBody){
        clienteService.replace(id,clientePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
