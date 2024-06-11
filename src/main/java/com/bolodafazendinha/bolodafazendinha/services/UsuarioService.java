package com.bolodafazendinha.bolodafazendinha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolodafazendinha.bolodafazendinha.models.UsuarioEntity;
import com.bolodafazendinha.bolodafazendinha.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;
    
    public UsuarioEntity salvar(UsuarioEntity usuario) {
        
        return usuarioRepository.save(usuario);
    }
	
}
