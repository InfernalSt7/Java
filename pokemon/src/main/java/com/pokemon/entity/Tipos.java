package com.pokemon.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo")

public class Tipos {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_tipo")
    private int id;
    
    @Column(name="nombre")
    private String nombre;

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

	public Tipos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Tipos() {
		super();
	}
   

	

	
    
    

	

	
    
}


























/*package com.pokemon.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipo")
public class Tipos{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "listaT")
    private List<Pokemon> listaP;

	public Tipos(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Tipos() {}

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
	
	
	
}*/
