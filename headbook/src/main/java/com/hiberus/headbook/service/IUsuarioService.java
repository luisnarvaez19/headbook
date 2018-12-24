package com.hiberus.headbook.service;

import java.util.UUID;

import com.hiberus.headbook.model.Usuario;

public interface IUsuarioService {
	public Usuario getUsuario(UUID id);
	public Usuario getUsuarioByUsername(String username);
	void saveUsuario(Usuario usuario);
}
