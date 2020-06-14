package com.pokemon.model;

public class EquipoModel {

	private int id;
	private String nombre;
	private String descripcion;
	private PokemonModel pokemon;
	public EquipoModel(int id, String nombre, String descripcion, PokemonModel pokemon) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pokemon = pokemon;
	}
	public EquipoModel() {
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public PokemonModel getPokemon() {
		return pokemon;
	}
	public void setPokemon(PokemonModel pokemon) {
		this.pokemon = pokemon;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
