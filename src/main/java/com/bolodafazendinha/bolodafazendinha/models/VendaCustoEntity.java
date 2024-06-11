package com.bolodafazendinha.bolodafazendinha.models;

import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.bolodafazendinha.bolodafazendinha.enums.ProdutoClienteEnum;
import com.bolodafazendinha.bolodafazendinha.enums.SimNaoEnum;
import com.bolodafazendinha.bolodafazendinha.enums.TipoCadastroEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@Table(name = "venda_custo")
public class VendaCustoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name= "ID")
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "tipo_cadastro")
	private TipoCadastroEnum tipoCadastro;
	
	@Column(name= "descricao_produto_cliente")
	private String descricaoProdutoCliente;
	
	@Column(name= "data_venda_custo")
	private Date dataVendaCusto;
	
	@Column(name= "valor")
	private Long valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "registro_excluido")
	private SimNaoEnum registroExcluido;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "produto_cliente")
	private ProdutoClienteEnum produtoCliente;
	
	@CreationTimestamp
	@Column(name= "data_criado", updatable = false)
	private LocalDateTime dataCriado;
	
	@UpdateTimestamp
	@Column(name= "data_alterado")
	private LocalDateTime dataAlterado;
	
	@Column(name= "data_excluido")
	private LocalDateTime dataExcluido;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoCadastroEnum getTipoCadastro() {
		return tipoCadastro;
	}

	public void setTipoCadastro(TipoCadastroEnum tipoCadastro) {
		this.tipoCadastro = tipoCadastro;
	}

	public String getDescricaoProdutoCliente() {
		return descricaoProdutoCliente;
	}

	public void setDescricaoProdutoCliente(String descricaoProdutoCliente) {
		this.descricaoProdutoCliente = descricaoProdutoCliente;
	}

	public Date getDataVendaCusto() {
		return dataVendaCusto;
	}

	public void setDataVendaCusto(Date dataVendaCusto) {
		this.dataVendaCusto = dataVendaCusto;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public SimNaoEnum getRegistroExcluido() {
		return registroExcluido;
	}

	public void setRegistroExcluido(SimNaoEnum registroExcluido) {
		this.registroExcluido = registroExcluido;
	}

	public ProdutoClienteEnum getProdutoCliente() {
		return produtoCliente;
	}

	public void setProdutoCliente(ProdutoClienteEnum produtoCliente) {
		this.produtoCliente = produtoCliente;
	}

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

	public LocalDateTime getDataExcluido() {
		return dataExcluido;
	}

	public void setDataExcluido(LocalDateTime dataExcluido) {
		this.dataExcluido = dataExcluido;
	}
	
	
}
