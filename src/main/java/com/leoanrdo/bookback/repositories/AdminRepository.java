package com.leoanrdo.bookback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leoanrdo.bookback.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
}
