package com.pokemon.model;

public class CompeticionModel {

	private int id;
	private String nombre;
	private String fecha;
	private String lugar;
	
	public CompeticionModel(int id, String nombre, String fecha, String lugar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
	}
	
	public CompeticionModel() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String string) {
		this.fecha = string;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
	
}
