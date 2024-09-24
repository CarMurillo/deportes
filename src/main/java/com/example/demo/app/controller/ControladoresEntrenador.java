package com.example.demo.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.app.Servicios.ServiciosEntrenador;
import com.example.demo.app.variable.Entrenador;

@Controller
public class ControladoresEntrenador {

	@Autowired
	private ServiciosEntrenador ServiciosEntrenador;
	
	@GetMapping("/verEntrenador.html")  
	public String listarEntrenador(Model model) {
		List<Entrenador> listaEntrenador = ServiciosEntrenador.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "verEntrenador";
	}
	
	@GetMapping("/formEntrenador.html")
	public String mostrarFormulario (Model model) {
		model.addAttribute("entrenador", new Entrenador());
		
		List<Entrenador> listaEntrenador = ServiciosEntrenador.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador";
	}
	
	@PostMapping("/guardarEntrenador")
	public String guardaEntrenador(Entrenador entrenador) {
		ServiciosEntrenador.save(entrenador);
		return "redirect:/verEntrenador.html";
	}
	
	@GetMapping("/entrenador/editarEntrenador/{id}")
	public String modificarEntrenador (@PathVariable("id") Long id, Model model) {
		Entrenador entrenador = ServiciosEntrenador.findById(id).get();
		model.addAttribute("entrenador", entrenador);
		
		List<Entrenador> listaEntrenador = ServiciosEntrenador.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		return "formEntrenador";
	}
	
	@GetMapping("/entrenador/eliminarEntrenador/{id}")
	public String eliminarEntrenador(@PathVariable("id") Long id, Model model) {
		ServiciosEntrenador.deleteById(id);
		return "redirect:/verEntrenador.html";
	}
}
