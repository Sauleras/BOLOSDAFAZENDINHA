package com.bolodafazendinha.bolodafazendinha.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApuracaoDadosDto {
	@NotNull(message = "data início é obrigatório")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataInicio;
	
	@NotNull(message = "data final é obrigatória")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataFinal;
	
	private Long totalVendas;
	
	private Long totalCustos;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Long getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(Long totalVendas) {
		this.totalVendas = totalVendas;
	}

	public Long getTotalCustos() {
		return totalCustos;
	}

	public void setTotalCustos(Long totalCustos) {
		this.totalCustos = totalCustos;
	}
	
}
