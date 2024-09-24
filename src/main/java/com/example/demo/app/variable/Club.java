package com.example.demo.app.variable;

import java.util.List;

/*import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/*import jakarta.persistence.FetchType;*/
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clubes")
public class Club {
@Id
@GeneratedValue( strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;

@OneToOne
private Entrenador entrenador;

@OneToMany
@JoinColumn(name = "id_club")
private List<Jugador>jugadores;

@ManyToOne
private Asociacion asociacion;

@ManyToMany
private List<Competicion> competiciones;

public Club(){}

public Club(Long id, Entrenador entrenador, List<Jugador>jugadores, Asociacion asociacion, List<Competicion>competiciones) {
this.asociacion= asociacion;
this.id = id;
this.entrenador = entrenador;
this.jugadores = jugadores;
this.competiciones = competiciones;
}

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

public Entrenador getEntrenador() {
    return entrenador;
}

public void setEntrenador(Entrenador entrenador) {
    this.entrenador = entrenador;
}

public Asociacion getAsociacion() {
    return asociacion;
}

public void setAsociacion(Asociacion asociacion) {
    this.asociacion = asociacion;
}
//----------------------------------------

}