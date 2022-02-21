package com.leoanrdo.bookback.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leoanrdo.bookback.domain.dtos.AdminDTO;
import com.leoanrdo.bookback.domain.enums.Perfil;

public class Admin extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "admin")
	private List<Admin> admins = new ArrayList<>();

	public Admin() {
		super();
		addPerfil(Perfil.CLIENTE);
	}
	public Admin(AdminDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.usuario = obj.getUsuario();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getId()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}
	
	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	
	
}
