package com.leoanrdo.bookback.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.leoanrdo.bookback.domain.Cliente;
import com.leoanrdo.bookback.domain.Livro;
import com.leoanrdo.bookback.domain.dtos.LivroDTO;
import com.leoanrdo.bookback.repositories.LivroRepository;
import com.leoanrdo.bookback.services.exceptions.ObjectnotFoundExceptions;


public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
//	@Autowired
//	private AdminService adminService;
	@Autowired
	private ClienteService clienteService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundExceptions("Objeto não encontrado ID: " + id));
	}

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro create(@Valid LivroDTO objDTO) {
		return repository.save(newLivro(objDTO));
	}

	public Livro update(Integer id, @Valid LivroDTO objDTO) {
		objDTO.setId(id);
		Livro oldObj = findById(id);
		oldObj = newLivro(objDTO);
		return repository.save(oldObj);
	}
	
	private Livro newLivro(LivroDTO obj) {
//		Admin admin = adminService.findById(obj.getAdmin());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Livro livro = new Livro();
		if (obj.getId() != null) {
			livro.setId(obj.getId());
		}
//		livro.setAdmin(admin);
		livro.setCliente(cliente);
		livro.setTitulo(obj.getTitulo());
		livro.setObservacoes(obj.getObservacoes());
		return livro;
		
	}

}
