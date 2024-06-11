package com.bolodafazendinha.bolodafazendinha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolodafazendinha.bolodafazendinha.models.UsuarioEntity;
import com.bolodafazendinha.bolodafazendinha.repository.UsuarioRepository;

@Service
public class AutenticacaoService {
	
	@Autowired
    private UsuarioRepository usuarioRepository;

    public boolean autenticar(String cpf, String senha) {
    	UsuarioEntity usuario = usuarioRepository.findByCpf(cpf);
        if (usuario != null) {
        	return senha.equals(usuario.getSenha());
        }
        return false;
    }
}
