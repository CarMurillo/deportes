package com.example.demo.app.variable;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "competiciones")
public class Competicion {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
public Long id;
public String nombre;
public int montoPremio;
public LocalDate fechaInicio;
public LocalDate fechaFin;

/*Getters y Setters*/
//----------------------------------------
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public int getMontoPremio() {
	return montoPremio;
}

public void setMontoPremio(int montoPremio) {
	this.montoPremio = montoPremio;
}

public LocalDate getFechaInicio() {
	return fechaInicio;
}

public void setFechaInicio(LocalDate fechaInicio) {
	this.fechaInicio = fechaInicio;
}

public LocalDate getFechaFin() {
	return fechaFin;
}

public void setFechaFin(LocalDate fechaFin) {
	this.fechaFin = fechaFin;
}
//----------------------------------------

}
