package com.jflores.springboot.web.app.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jflores.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@GetMapping({"index", "/"," ", "home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Jose");
		usuario.setApellido("Flores");
		usuario.setEmail("jose@correo.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de Usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Listado de usuarios");
	
	return "listar";
	}
	
	@ModelAttribute("usuarios") 
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Andres", "Guzman", "andres@correo.com"),
				new Usuario("Jhon", "Perez", "jhoe@correo.com"),
				new Usuario("Jane", "Gomez", "jane@correo.com"),
				new Usuario("Tornado", "Roe", "tor@correo.com"));
		
		return usuarios;
	}
}
