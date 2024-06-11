package com.bolodafazendinha.bolodafazendinha.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolodafazendinha.bolodafazendinha.enums.ProdutoClienteEnum;
import com.bolodafazendinha.bolodafazendinha.enums.SimNaoEnum;
import com.bolodafazendinha.bolodafazendinha.enums.TipoCadastroEnum;
import com.bolodafazendinha.bolodafazendinha.models.VendaCustoDto;
import com.bolodafazendinha.bolodafazendinha.models.VendaCustoEntity;
import com.bolodafazendinha.bolodafazendinha.repository.VendaCustoRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/vendaCusto")
public class VendaCustoController {

	@Autowired
	private VendaCustoRepository repo;
	
	@GetMapping({"", "/"})
	public String telaVendaCusto(Model model) {
	    List<VendaCustoEntity> vendasCustos = repo.findByDataExcluidoIsNull(Sort.by(Sort.Direction.DESC, "id"));
	    model.addAttribute("vendasCustos", vendasCustos);
	    
	    VendaCustoDto vendaCustoDto = new VendaCustoDto();
	    model.addAttribute("vendaCustoDto", vendaCustoDto);
	    
	    return "vendaCusto/index";
	}
	
	@PostMapping("/adicionar")
	public String salvarVendaCusto(@Valid @ModelAttribute VendaCustoDto vendaCustoDto, BindingResult result) {		
		
		if (result.hasErrors()) {
			return "vendaCusto/index"; 
		}
		
		try {
			
			VendaCustoEntity vendaCustoEntity;
			
			if (vendaCustoDto.getId() != 0) {
				vendaCustoEntity = repo.findById(vendaCustoDto.getId()).get();
	        } else {	        	
	        	vendaCustoEntity = new VendaCustoEntity();
	        }
			vendaCustoEntity.setTipoCadastro(vendaCustoDto.getTipoCadastro());
			vendaCustoEntity.setDescricaoProdutoCliente(vendaCustoDto.getDescricaoProdutoCliente());
			vendaCustoEntity.setDataVendaCusto(vendaCustoDto.getDataVendaCusto());
			vendaCustoEntity.setValor(vendaCustoDto.getValor());
			
			if (vendaCustoDto.getTipoCadastro() == TipoCadastroEnum.VENDA) {
				vendaCustoEntity.setProdutoCliente(ProdutoClienteEnum.CLIENTE);
			} else {
				vendaCustoEntity.setProdutoCliente(ProdutoClienteEnum.PRODUTO);
			}
			
			vendaCustoEntity.setRegistroExcluido(SimNaoEnum.NAO);
			
			repo.save(vendaCustoEntity);
		} 
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		return "redirect:/vendaCusto";
	}
	
	@GetMapping("/editar")
	public String editarVendaCusto(Model model, @RequestParam int id) {
		try {
			VendaCustoEntity vendaCustoEntity = repo.findById(id).get();
		    model.addAttribute("vendaCusto", vendaCustoEntity);
		    
		    VendaCustoDto vendaCustoDto = new VendaCustoDto();
		    vendaCustoDto.setId(vendaCustoEntity.getId());
		    vendaCustoDto.setTipoCadastro(vendaCustoEntity.getTipoCadastro());
		    vendaCustoDto.setDescricaoProdutoCliente(vendaCustoEntity.getDescricaoProdutoCliente());
		    vendaCustoDto.setDataVendaCusto(vendaCustoEntity.getDataVendaCusto());
		    vendaCustoDto.setValor(vendaCustoEntity.getValor());
		    
		    model.addAttribute("vendaCustoDto", vendaCustoDto);
		}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		return "vendaCusto/index";
	}
	
	@GetMapping("/excluir")
	public String deletarVendaCusto(@RequestParam int id) {
		try {
			VendaCustoEntity vendaCustoEntity = repo.findById(id).get();
			LocalDateTime dataAtual = LocalDateTime.now();
			
			vendaCustoEntity.setRegistroExcluido(SimNaoEnum.SIM);
			vendaCustoEntity.setDataExcluido(dataAtual);
			
			repo.save(vendaCustoEntity);
		}
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		return "redirect:/vendaCusto";
	}
	
}
