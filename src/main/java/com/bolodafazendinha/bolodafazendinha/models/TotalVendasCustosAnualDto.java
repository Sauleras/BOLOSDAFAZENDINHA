package com.bolodafazendinha.bolodafazendinha.models;

import java.math.BigDecimal;

public class TotalVendasCustosAnualDto {
	
	private String ano;
    private BigDecimal totalValor;

    public TotalVendasCustosAnualDto(String ano, BigDecimal totalValor) {
        this.setAno(ano);
        this.setTotalValor(totalValor);
    }

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public BigDecimal getTotalValor() {
		return totalValor;
	}

	public void setTotalValor(BigDecimal totalValor) {
		this.totalValor = totalValor;
	}

}
