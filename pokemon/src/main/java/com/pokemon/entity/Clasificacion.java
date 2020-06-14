package com.pokemon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="clasificacion")
public class Clasificacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="competicion")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Competicion competicion;
	
	@ManyToOne
	@JoinColumn(name="equipo")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Equipo equipo;
	
	@Column(name="puesto")
	private String puesto;
	
	@Column(name="puntos")
	private int puntos;

	public Clasificacion(int id, Competicion competicion, Equipo equipo, String puesto, int puntos) {
		super();
		this.id = id;
		this.competicion = competicion;
		this.equipo = equipo;
		this.puesto = puesto;
		this.puntos = puntos;
	}

	public Clasificacion() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Competicion getCompeticion() {
		return competicion;
	}

	public void setCompeticion(Competicion competicion) {
		this.competicion = competicion;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	
	
	
}
