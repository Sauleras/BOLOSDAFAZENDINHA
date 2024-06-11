package com.bolodafazendinha.bolodafazendinha.models;

import com.bolodafazendinha.bolodafazendinha.enums.PerfilUsuarioEnum;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
	private int id;
	
	@NotEmpty(message = "cpf é obrigatório")
	private String cpf;
	
	@NotEmpty(message = "senha é obrigatório")
	private String senha;
	
	@NotNull(message = "perfil é obrigatório")
	private PerfilUsuarioEnum perfil;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilUsuarioEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuarioEnum perfil) {
		this.perfil = perfil;
	}
	

}
