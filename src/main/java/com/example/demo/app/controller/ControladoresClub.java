package com.example.demo.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.app.Servicios.ServiciosAsociacion;
import com.example.demo.app.Servicios.ServiciosClub;
import com.example.demo.app.Servicios.ServiciosCompeticion;
import com.example.demo.app.Servicios.ServiciosEntrenador;
import com.example.demo.app.variable.Asociacion;
import com.example.demo.app.variable.Club;
import com.example.demo.app.variable.Competicion;
import com.example.demo.app.variable.Entrenador;

@Controller
public class ControladoresClub {

	@Autowired
	private ServiciosClub clubRepositorio;
	
	@Autowired
	private ServiciosEntrenador entrenadorRepositorio;
	
	@Autowired
	private ServiciosAsociacion asociacionRepositorio;
	
	@Autowired
	private ServiciosCompeticion competicionRepositorio;
	
	@GetMapping("/verClub.html")  
	public String listarClub(Model model) {
		List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
		return "verClub";
	}
	
	@GetMapping("/formclub.html")
	public String mostrarFormulario (Model model) {
		model.addAttribute("club", new Club());
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@PostMapping("/guardarClub")
	public String guardarClub (Club club) {
		clubRepositorio.save(club);
		return "redirect:/verClub.html";
	}
	
	@GetMapping("/club/editar/{id}")
	public String modificarClub (@PathVariable("id") Long id, Model model) {
		Club club = clubRepositorio.findById(id).get();
		model.addAttribute("club", club);
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "formClub";
	}
	
	@GetMapping("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Long id, Model model) {
		clubRepositorio.deleteById(id);
		return "redirect:/verClub.html";
	}
	
}
