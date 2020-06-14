package com.pokemon.model;

public class PokemonModel {

	private int id;
	private String foto;
	private String nombre;
	private int ataque;
	private int defensa;
	private TipoModel tipo;
	private MovimientoModel movimiento;
	public PokemonModel(int id, String foto, String nombre, int ataque, int defensa, TipoModel tipo,
			MovimientoModel movimiento) {
		super();
		this.id = id;
		this.foto = foto;
		this.nombre = nombre;
		this.ataque = ataque;
		this.defensa = defensa;
		this.tipo = tipo;
		this.movimiento = movimiento;
	}
	public PokemonModel() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
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
	public TipoModel getTipo() {
		return tipo;
	}
	public void setTipo(TipoModel tipo) {
		this.tipo = tipo;
	}
	public MovimientoModel getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(MovimientoModel movimiento) {
		this.movimiento = movimiento;
	}

	
	
	
	

	
	
	
	
}















/*package com.pokemon.model;

import java.util.List;

import com.pokemon.entity.Movimiento;
import com.pokemon.entity.Tipos;

public class PokemonModel {

	private int id;
	private String nombre;
	private String foto;
	private int ataque;
	private int defensa;
	private List<Tipos> listaT;
	private List<Movimiento> listaM;
	
	public PokemonModel(int id, String nombre, String foto, int ataque, int defensa, List<Tipos> listaT,
			List<Movimiento> listaM) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.ataque = ataque;
		this.defensa = defensa;
		this.listaT = listaT;
		this.listaM = listaM;
	}
	public PokemonModel() {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} */