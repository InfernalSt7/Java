package com.pokemon.model;

import com.pokemon.entity.Equipo;
import com.pokemon.entity.User;

public class EntrenadorModel {

	private int id;
	private String nombre;
	private String foto;
	private int telefono;
	private String email;
	private User user;
	private Equipo equipo;
	
	public EntrenadorModel(int id, String nombre, String foto, int telefono, String email, User user, Equipo equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.telefono = telefono;
		this.email = email;
		this.user = user;
		this.equipo = equipo;
	}

	public EntrenadorModel() {}

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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	
	
	
	
}
