package com.hiberus.headbook.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hiberus.headbook.model.Usuario;
import com.hiberus.headbook.repository.UsuarioRepository;

@Service(value = "userService")
public class UsuarioService implements IUsuarioService, UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario getUsuario(UUID id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}
	
	@Override
	public void saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = getUsuarioByUsername(username);
		if (user != null) {
			String password="{noop}"+user.getPassword();
			return new org.springframework.security.core.userdetails.User(user.getUsername(),
					password, getAuthority());
		} 
		throw new UsernameNotFoundException(username);
	}

	@Override
	public Usuario getUsuarioByUsername(String username) {
		// TODO Auto-generated method stub
		return usuarioRepository.findUsuarioByUsername(username);
	}


	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}
}
