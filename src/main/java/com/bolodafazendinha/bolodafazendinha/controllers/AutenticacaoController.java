package com.bolodafazendinha.bolodafazendinha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolodafazendinha.bolodafazendinha.models.AutenticacaoDto;
import com.bolodafazendinha.bolodafazendinha.services.AutenticacaoService;

@Controller
public class AutenticacaoController {
	
	@Autowired
    private AutenticacaoService autenticacaoService;
	
	@GetMapping({"", "/"})
	public String telaLogin(Model model) {
		AutenticacaoDto autenticacaoDto = new AutenticacaoDto();
	    model.addAttribute("autenticacaoDto", autenticacaoDto);
	    
	    return "usuario/index";
	}

	@PostMapping({"", "/"})
	public String login(@RequestParam String cpf, @RequestParam String senha, Model model) {
	    if (autenticacaoService.autenticar(cpf, senha)) {
	        return "menu";
	    } else {
	    	model.addAttribute("error", "Credenciais inválidas. Por favor, tente novamente.");
	    	AutenticacaoDto autenticacaoDto = new AutenticacaoDto();
	        model.addAttribute("autenticacaoDto", autenticacaoDto);
	        return "usuario/index";
	    }
	}

}
