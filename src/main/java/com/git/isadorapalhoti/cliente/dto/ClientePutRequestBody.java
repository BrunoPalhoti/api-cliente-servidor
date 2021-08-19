package com.git.isadorapalhoti.cliente.dto;

import lombok.Data;

@Data
public class ClientePutRequestBody {
    private Integer id;
    private String nome;
    private String cpf;
}
