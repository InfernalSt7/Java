package com.pokemon.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="equipo")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_pkmn")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Pokemon pokemon;
	
	/*@JoinTable(
	        name = "rel_pokemon_equip",
	        joinColumns = @JoinColumn(name = "FK_POKEMON", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_EQUIP", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Pokemon> listaP;*/

	public Equipo(int id, String nombre, String descripcion, Pokemon pokemon) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.pokemon = pokemon;
	}

	public Equipo() {}

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

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	
	
	
	
	
}
