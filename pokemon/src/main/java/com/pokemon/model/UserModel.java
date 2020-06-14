package com.pokemon.model;

import com.pokemon.entity.Entrenador;

public class UserModel {
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	private String role;
	
	private Entrenador entrenador;

	public UserModel(String username, String password, boolean enabled, String role, Entrenador entrenador) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.entrenador = entrenador;
	}

	public UserModel() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	
	

	
	
	
}
