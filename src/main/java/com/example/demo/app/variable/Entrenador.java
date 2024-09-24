package com.example.demo.app.variable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "entrenadores")
public class Entrenador {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
public Long id;
public String nombre;
public String apellido;
public int edad;
public String nacionalidad;

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

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public int getEdad() {
	return edad;
}

public void setEdad(int edad) {
	this.edad = edad;
}

public String getNacionalidad() {
	return nacionalidad;
}

public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}
//----------------------------------------

}