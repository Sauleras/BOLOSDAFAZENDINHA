package com.bolodafazendinha.bolodafazendinha.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolodafazendinha.bolodafazendinha.models.ApuracaoDadosDto;
import com.bolodafazendinha.bolodafazendinha.models.TotalVendasCustosAnualDto;
import com.bolodafazendinha.bolodafazendinha.repository.VendaCustoRepository;
import com.bolodafazendinha.bolodafazendinha.services.EstoqueService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/apuracaoDados")
public class apuracaoDadosController {
	@Autowired
	private VendaCustoRepository repo;
	
	@Autowired
    private EstoqueService estoqueService;
	
	@GetMapping({"", "/"})
	public String telaApuracaoDados(Model model) {
			
		ApuracaoDadosDto apuracaoDadosDto = new ApuracaoDadosDto();
		List<TotalVendasCustosAnualDto> totalVendasCustosAnualDto = calcularTotalVendasCustosMensais();
		
	    model.addAttribute("apuracaoDadosDto", apuracaoDadosDto);
	    model.addAttribute("estoqueDto", totalVendasCustosAnualDto);
	    
	    return "apuracaoDados/apuracaoDados";
	}
	
	@PostMapping("/buscar")
	public String buscarApuracaoDados(@Valid @ModelAttribute ApuracaoDadosDto apuracaoDadosDto, BindingResult result, RedirectAttributes redirectAttributes) {        
	    if (result.hasErrors()) {
	        return "apuracaoDados/ApuracaoDados"; 
	    }
	    
	    List<Object[]> apuracaoDados = repo.getApuracaoDados(apuracaoDadosDto.getDataInicio(), apuracaoDadosDto.getDataFinal());
	    
	    System.out.println(apuracaoDados);
	    redirectAttributes.addFlashAttribute("apuracaoDados", apuracaoDados);
	    
	    return "redirect:/apuracaoDados";
	}
	
    public List<TotalVendasCustosAnualDto> calcularTotalVendasCustosMensais() {
        return estoqueService.calcularTotalVendasCustosAnual();
    }
	
}
