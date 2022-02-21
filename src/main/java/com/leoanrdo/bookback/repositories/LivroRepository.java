package com.leoanrdo.bookback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoanrdo.bookback.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
}
