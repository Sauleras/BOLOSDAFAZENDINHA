package com.bolodafazendinha.bolodafazendinha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bolodafazendinha.bolodafazendinha.models.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{
	UsuarioEntity findByCpf(String cpf);

}
