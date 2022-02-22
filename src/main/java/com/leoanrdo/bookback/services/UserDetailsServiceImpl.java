package com.leoanrdo.bookback.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.leoanrdo.bookback.domain.Pessoa;
import com.leoanrdo.bookback.repositories.PessoaRepository;
import com.leoanrdo.bookback.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private PessoaRepository repository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		Optional<Pessoa> user = repository.findByUsuario(usuario);
		if(user.isPresent()) {
			return new UserSS(user.get().getId(), user.get().getSenha(), user.get().getUsuario(), user.get().getPerfis());
		}
		throw new UsernameNotFoundException(usuario);
	}
	
}
