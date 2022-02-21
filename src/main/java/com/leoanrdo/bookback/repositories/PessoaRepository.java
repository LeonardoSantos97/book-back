package com.leoanrdo.bookback.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoanrdo.bookback.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	Optional<Pessoa> findByUsuario(String usuario);
}
