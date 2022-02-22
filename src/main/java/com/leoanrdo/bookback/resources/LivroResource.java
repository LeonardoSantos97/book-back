package com.leoanrdo.bookback.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leoanrdo.bookback.domain.Livro;
import com.leoanrdo.bookback.domain.dtos.LivroDTO;
import com.leoanrdo.bookback.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> findById(@PathVariable Integer id){
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(new LivroDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(){
		List<Livro> list = service.findAll();
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<LivroDTO> create(@Valid @RequestBody LivroDTO objDTO){
		Livro obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @Valid @RequestBody LivroDTO objDTO){
		Livro newObj = service.update(id, objDTO);
		return ResponseEntity.ok(new LivroDTO(newObj));
	}
}