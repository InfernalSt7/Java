package com.pokemon.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="entrenador")
public class Entrenador {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="telefono")
	private int telefono;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(mappedBy="entrenador", cascade=CascadeType.ALL)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="equipo")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Equipo equipo;

	public Entrenador(int id, String nombre, String foto, int telefono, String email, User user, Equipo equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.telefono = telefono;
		this.email = email;
		this.user = user;
		this.equipo = equipo;
	}

	public Entrenador() {}

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
