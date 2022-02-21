package com.leoanrdo.bookback.domain;

import java.util.ArrayList;
import java.util.List;

public class Admin extends Pessoa{
	
	private List<Admin> admins = new ArrayList<>();

	public Admin() {
		super();
	}

	public Admin(Integer id, String nome, String usuario, String senha) {
		super(id, nome, usuario, senha);
	}

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	
	
}
