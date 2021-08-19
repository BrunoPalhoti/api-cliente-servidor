package com.git.isadorapalhoti.cliente.service;

import com.git.isadorapalhoti.cliente.domain.Cliente;
import com.git.isadorapalhoti.cliente.dto.ClientePostRequestBody;
import com.git.isadorapalhoti.cliente.dto.ClientePutRequestBody;
import com.git.isadorapalhoti.cliente.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public List<Cliente> listAll(){
        return clienteRepository.findAll();
    }

    public Cliente findByIdOrThrowBadRequestException(Integer id){
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente ID not fund"));
    }

    public Cliente save(ClientePostRequestBody clientePostRequestBody){
        return clienteRepository.save(Cliente.builder()
                .nome(clientePostRequestBody.getNome())
                .cpf(clientePostRequestBody.getCpf())
                .build());
    }

    public void delete(Integer id){
       clienteRepository
               .findById(id)
               .map(cliente -> {
                   clienteRepository.delete(cliente);
                   return Void.TYPE;
               })
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public void replace(Integer id, ClientePutRequestBody clientePutRequestBody){
        clienteRepository
                .findById(id)
                .map(cliente -> {
                    cliente.setNome(clientePutRequestBody.getNome());
                    return clienteRepository.save(cliente);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
}
