package com.leoanrdo.bookback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoanrdo.bookback.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
