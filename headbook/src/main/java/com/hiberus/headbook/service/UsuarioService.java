package com.hiberus.headbook.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.headbook.model.Usuario;
import com.hiberus.headbook.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

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

}
