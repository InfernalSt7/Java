package com.pokemon.model;

import java.util.List;

import com.pokemon.entity.Pokemon;

public class MovimientoModel {

	private int id;
	private String nombre;
	private String categoria;
	private String descripcion;
	private int potencia;
	private int precission;
	private List<Pokemon> listaP;
	public MovimientoModel(int id, String nombre, String categoria, String descripcion, int potencia, int precission,
			List<Pokemon> listaP) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.potencia = potencia;
		this.precission = precission;
		this.listaP = listaP;
	}
	public MovimientoModel() {
		super();
	}
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public int getPrecission() {
		return precission;
	}
	public void setPrecission(int precission) {
		this.precission = precission;
	}
	public List<Pokemon> getListaP() {
		return listaP;
	}
	public void setListaP(List<Pokemon> listaP) {
		this.listaP = listaP;
	}
	
	
	
	
	
	
	
	
	
	
}
