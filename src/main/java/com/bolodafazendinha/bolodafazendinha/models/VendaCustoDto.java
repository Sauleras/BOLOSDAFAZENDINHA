package com.bolodafazendinha.bolodafazendinha.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bolodafazendinha.bolodafazendinha.enums.TipoCadastroEnum;

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
public class VendaCustoDto {
	private int id;
	
	@NotNull(message = "tipo de cadastro é obrigatório")
	private TipoCadastroEnum tipoCadastro;
	
	@NotEmpty(message = "nome do produto ou cliente é obrigatório")
	private String descricaoProdutoCliente;
	
	@NotNull(message = "data da venda/custo é obrigatório")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataVendaCusto;
	
	@NotNull(message = "valor é obrigatório")
	private Long valor;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
}
