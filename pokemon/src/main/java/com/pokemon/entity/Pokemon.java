package com.pokemon.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="pokemon")
public class Pokemon {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_pkmn")
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="foto")
    private String foto;
    
    @Column(name="ataque")
    private int ataque;
    
    @Column(name="defensa")
    private int defensa;
    
    @ManyToOne
	@JoinColumn(name="equipo")
	@OnDelete(action=OnDeleteAction.CASCADE)
    private Equipo equipo;
	
    @ManyToOne
	@JoinColumn(name="id_tipo")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Tipos tipo;
    
    @ManyToOne
	@JoinColumn(name="id_movimiento")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Movimiento movimiento;

	public Pokemon(int id, String nombre, String foto, int ataque, int defensa, Equipo equipo, Tipos tipo,
			Movimiento movimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.ataque = ataque;
		this.defensa = defensa;
		this.equipo = equipo;
		this.tipo = tipo;
		this.movimiento = movimiento;
	}

	public Pokemon() {
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Tipos getTipo() {
		return tipo;
	}

	public void setTipo(Tipos tipo) {
		this.tipo = tipo;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}


	
	
    

	
	
	 

	
	
	
	
}






















/*package com.pokemon.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ataque")
	private int ataque;
	
	@Column(name="defensa")
	private int defensa;
	
	@Column(name="foto")
	private String foto;
	
	@JoinTable(
	        name = "rel_pokemon_tipos",
	        joinColumns = @JoinColumn(name = "FK_POKEMON", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_TIPOS", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Tipos> listaT;
	
	@JoinTable(
	        name = "rel_pokemon_movs",
	        joinColumns = @JoinColumn(name = "FK_POKEMON", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_MOVS", nullable = false)
	    )
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Movimiento> listaM;
	
	@ManyToMany(mappedBy = "listaP")
	private Set<Equipo> equipo;

	public Pokemon(int id, String nombre, int ataque, int defensa, String foto, List<Tipos> listaT,
			List<Movimiento> listaM, Set<Equipo> equipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.foto = foto;
		this.listaT = listaT;
		this.listaM = listaM;
		this.equipo = equipo;
	}

	public Pokemon() {}

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

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Tipos> getListaT() {
		return listaT;
	}

	public void setListaT(List<Tipos> listaT) {
		this.listaT = listaT;
	}

	public List<Movimiento> getListaM() {
		return listaM;
	}

	public void setListaM(List<Movimiento> listaM) {
		this.listaM = listaM;
	}

	public Set<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(Set<Equipo> equipo) {
		this.equipo = equipo;
	}

	
	
	

	

	
	
	

	
	

	
	
	

	
	

	
	
}*/
