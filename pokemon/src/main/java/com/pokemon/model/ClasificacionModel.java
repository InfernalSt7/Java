package com.pokemon.model;

import com.pokemon.entity.Competicion;
import com.pokemon.entity.Equipo;

public class ClasificacionModel {
	
	private int id;
	private int puntos;
	private String puesto;
	private Competicion id_competicion;
	private Equipo id_equipo;
	
	public ClasificacionModel(int id, int puntos, String puesto, Competicion id_competicion, Equipo id_equipo) {
		super();
		this.id = id;
		this.puntos = puntos;
		this.puesto = puesto;
		this.id_competicion = id_competicion;
		this.id_equipo = id_equipo;
	}
	
	public ClasificacionModel() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Competicion getId_competicion() {
		return id_competicion;
	}

	public void setId_competicion(Competicion id_competicion) {
		this.id_competicion = id_competicion;
	}

	public Equipo getId_equipo() {
		return id_equipo;
	}

	public void setId_equipo(Equipo id_equipo) {
		this.id_equipo = id_equipo;
	}
	
	

}
