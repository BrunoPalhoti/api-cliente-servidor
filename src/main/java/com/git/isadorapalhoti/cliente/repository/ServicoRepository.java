package com.git.isadorapalhoti.cliente.repository;

import com.git.isadorapalhoti.cliente.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
