package com.bolodafazendinha.bolodafazendinha.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.bolodafazendinha.bolodafazendinha.models.VendaCustoEntity;

public interface VendaCustoRepository extends JpaRepository<VendaCustoEntity, Integer>{
	
	List<VendaCustoEntity> findByDataExcluidoIsNull(Sort sort);
	
	@Query("SELECT MONTH(vc.dataVendaCusto) as month, " +
		       "SUM(CASE WHEN vc.tipoCadastro = 'VENDA' THEN vc.valor ELSE 0 END) as totalVendas, " +
		       "SUM(CASE WHEN vc.tipoCadastro = 'CUSTO' THEN vc.valor ELSE 0 END) as totalCustos " +
		       "FROM VendaCustoEntity vc " +
		       "WHERE vc.dataVendaCusto BETWEEN :ini AND :fim AND vc.dataExcluido IS NULL " +
		       "GROUP BY MONTH(vc.dataVendaCusto)")
	List<Object[]> getApuracaoDados(Date ini, Date fim);
	
	@Procedure(procedureName = "calcular_total_vendas_custos_anual")
    List<Object[]> calcularTotalVendasCustosAnual();

}
