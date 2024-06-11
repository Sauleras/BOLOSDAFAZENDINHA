package com.bolodafazendinha.bolodafazendinha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolodafazendinha.bolodafazendinha.models.TotalVendasCustosAnualDto;
import com.bolodafazendinha.bolodafazendinha.repository.VendaCustoRepository;

import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstoqueService {
    @Autowired
    private VendaCustoRepository vendaCustoRepository;

    @Transactional(readOnly = false)
    public List<TotalVendasCustosAnualDto> calcularTotalVendasCustosAnual() {
        List<Object[]> results = vendaCustoRepository.calcularTotalVendasCustosAnual();
        return results.stream()
                .map(result -> new TotalVendasCustosAnualDto((String) result[0], (BigDecimal) result[1]))
                .collect(Collectors.toList());
    }
}
