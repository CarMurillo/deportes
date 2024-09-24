package com.example.demo.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.app.Servicios.ServiciosCompeticion;
import com.example.demo.app.variable.Asociacion;
import com.example.demo.app.variable.Competicion;

@Controller
public class ControladoresCompeticion {

    @Autowired
    private ServiciosCompeticion serviciosCompeticion;

    @GetMapping("/verCompeticion.html")
    public String listarCompeticion(Model model) {
        List<Competicion> listaCompeticion = serviciosCompeticion.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "verCompeticion";
    }

    @GetMapping("/formcompe.html")
    public String mostrarFormularioCompeticion(Model model) {
        model.addAttribute("competicion", new Competicion());
        List<Competicion> listaCompeticion = serviciosCompeticion.findAll();
        model.addAttribute("listaCompeticion", listaCompeticion);
        return "formcompe";
    }

    @PostMapping("/guardarCompeticion")
    public String guardarCompeticion(Competicion competicion) {
        serviciosCompeticion.save(competicion);
        return "redirect:/verCompeticion.html";
    }

    @GetMapping("/competicion/editarCompeticion/{id}")
	public String modificarCompeticion (@PathVariable("id") Long id, Model model) {
		Competicion listaCompeticion = serviciosCompeticion.findById(id).get();
		model.addAttribute("competicion", listaCompeticion);
		
		List<Competicion> Competicion = serviciosCompeticion.findAll();
		model.addAttribute("listaCompeticion", Competicion);
		
		return "formcompe";
	}
	
	@GetMapping("/competicion/eliminarCompeticion/{id}")
	public String eliminarCompeticion(@PathVariable("id") Long id, Model model) {
		 serviciosCompeticion.deleteById(id);
		return "redirect:/verCompeticion.html";
	}
}
