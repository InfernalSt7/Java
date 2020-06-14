package com.pokemon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movimientos")

public class Movimiento{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_movimiento")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
	@Column(name="categoria")
	private String categoria;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @Column(name="potencia")
    private int potencia;
    
    @Column(name="precission")
    private int precission;
    

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

	public Movimiento(int id, String nombre, String categoria, String descripcion, int potencia, int precission) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.potencia = potencia;
		this.precission = precission;
	}

	public Movimiento() {
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
@Table(name="movimiento")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="potencia")
	private int potencia;
	
	@Column(name="precission")
	private int precission;

	@ManyToMany(mappedBy = "listaM")
	private List<Pokemon> listaP;

	public Movimiento(int id, String nombre, String categoria, String descripcion, int potencia, int precission,
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

	public Movimiento() {
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

	
	
	
	
	

	

	
	
	
	
	
	
	
	
}*/
