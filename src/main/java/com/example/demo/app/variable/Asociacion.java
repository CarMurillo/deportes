package com.example.demo.app.variable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "asociaciones")
public class Asociacion{
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
public Long id;
public String nombre;
public String pais;
public String presidente;

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

public String getPais() {
	return pais;
}

public void setPais(String pais) {
	this.pais = pais;
}

public String getPresidente() {
	return presidente;
}

public void setPresidente(String presidente) {
	this.presidente = presidente;
}
//----------------------------------------

}
