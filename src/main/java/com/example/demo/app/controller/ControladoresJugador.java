package com.example.demo.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.app.Servicios.ServiciosJugador;
import com.example.demo.app.variable.Jugador;

@Controller
public class ControladoresJugador {

	@Autowired
	private ServiciosJugador serviciosJugador;
	
	@GetMapping("/verJugador.html")  
	public String listarJugador(Model model) {
		List<Jugador> listaJugador = serviciosJugador.findAll();
		model.addAttribute("listaJugador", listaJugador);
		
		return "verJugador";
	}
	
	@GetMapping("/formJugador.html")
	public String mostrarFormulario (Model model) {
		model.addAttribute("jugador", new Jugador());
		
		List<Jugador> listaJugador = serviciosJugador.findAll();
		model.addAttribute("listaJugador", listaJugador);
		
		return "formJugador";
	}
	
	@PostMapping("/guardarJugador")
	public String guardarJugador (Jugador jugador) {
		serviciosJugador.save(jugador);
		return "redirect:/verJugador.html";
	}
	
	@GetMapping("/jugador/editarJugador/{id}")
	public String modificarJugador (@PathVariable("id") Long id, Model model) {
		Jugador jugador = serviciosJugador.findById(id).get();
		model.addAttribute("jugador", jugador);
		
		List<Jugador> listaJugador = serviciosJugador.findAll();
		model.addAttribute("listaJugador", listaJugador);
		
		return "formJugador";
	}
	
	@GetMapping("/jugador/eliminarJugador/{id}")
	public String eliminarJugador(@PathVariable("id") Long id, Model model) {
		serviciosJugador.deleteById(id);
		return "redirect:/verJugador.html";
	}
}
