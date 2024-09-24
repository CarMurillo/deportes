package com.example.demo.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.app.Servicios.ServiciosAsociacion;
import com.example.demo.app.variable.Asociacion;

@Controller
public class ControladoresAsociacion {

	@Autowired
	private ServiciosAsociacion ServiciosAsociacion;
	
	@GetMapping("/verAsociacion.html")  
	public String listarAsociacion(Model model) {
		List<Asociacion> listaAsociacion = ServiciosAsociacion.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		return "verAsociacion";
	}
	
	@GetMapping("/formAsociacion.html")
	public String mostrarFormularioAsociacion (Model model) {
		model.addAttribute("asociacion", new Asociacion());
			
		List<Asociacion> listaAsociacion = ServiciosAsociacion.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		return "formAsociacion";
	}
	
	@PostMapping("/guardarAsociacion")
	public String guardarAsociacion (Asociacion asociacion) {
		ServiciosAsociacion.save(asociacion);
		return "redirect:/verAsociacion.html";
	}
	
	@GetMapping("/asociacion/editarAsociacion/{id}")
	public String modificarAsociacion (@PathVariable("id") Long id, Model model) {
		Asociacion listaAsociacion = ServiciosAsociacion.findById(id).get();
		model.addAttribute("asociacion", listaAsociacion);
		
		List<Asociacion> Asociacion = ServiciosAsociacion.findAll();
		model.addAttribute("listaAsociacion", Asociacion);
		
		return "formAsociacion";
	}
	
	@GetMapping("/asociacion/eliminarAsociacion/{id}")
	public String eliminarAsociacion(@PathVariable("id") Long id, Model model) {
		 ServiciosAsociacion.deleteById(id);
		return "redirect:/verAsociacion.html";
	}
	
}
