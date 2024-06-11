package com.bolodafazendinha.bolodafazendinha.models;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.bolodafazendinha.bolodafazendinha.enums.PerfilUsuarioEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "ID")
	private int id;
	
	private String cpf;
	
	private String senha;
	
	private PerfilUsuarioEnum perfil;
	
	@CreationTimestamp
	@Column(name= "data_criado", updatable = false)
	private LocalDateTime dataCriado;
	
	public LocalDateTime getDataCriado() {
		return dataCriado;
	}

	public void setDataCriado(LocalDateTime dataCriado) {
		this.dataCriado = dataCriado;
	}

	public LocalDateTime getDataAlterado() {
		return dataAlterado;
	}

	public void setDataAlterado(LocalDateTime dataAlterado) {
		this.dataAlterado = dataAlterado;
	}

	@UpdateTimestamp
	@Column(name= "data_alterado")
	private LocalDateTime dataAlterado;

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
