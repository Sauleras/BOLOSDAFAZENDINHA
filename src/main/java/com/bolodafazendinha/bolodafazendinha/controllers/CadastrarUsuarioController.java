package com.bolodafazendinha.bolodafazendinha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolodafazendinha.bolodafazendinha.models.UsuarioDto;
import com.bolodafazendinha.bolodafazendinha.models.UsuarioEntity;
import com.bolodafazendinha.bolodafazendinha.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cadastrarUsuario")
public class CadastrarUsuarioController {
	@Autowired
	private UsuarioRepository repo;
	
	@GetMapping({"", "/"})
	public String telaCadastrarUsuario(Model model) {
	    UsuarioDto usuarioDto = new UsuarioDto();
	    model.addAttribute("usuarioDto", usuarioDto);
	    
	    return "usuario/cadastrar";
	}
	
	@PostMapping("/adicionar")
	public String salvarVendaCusto(@Valid @ModelAttribute UsuarioDto usuarioDto, BindingResult result) {		
		
		if (result.hasErrors()) {
			return "usuario/cadastrar"; 
		}
		
		try {
			
			UsuarioEntity usuarioEntity = new UsuarioEntity();
			usuarioEntity.setCpf(usuarioDto.getCpf());
			usuarioEntity.setSenha(usuarioDto.getSenha());
			usuarioEntity.setPerfil(usuarioDto.getPerfil());
			
			repo.save(usuarioEntity);
		} 
		catch(Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		return "redirect:/cadastrarUsuario";
	}

}
