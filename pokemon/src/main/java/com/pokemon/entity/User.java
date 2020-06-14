package com.pokemon.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="username", unique=true, length=45)
	private String username;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="user")
	private Set<User_Role> user_Role = new HashSet<User_Role>();

	@OneToOne
	@JoinColumn(name="entrenador")
	private Entrenador entrenador;

	public User(String username, String password, boolean enabled, Set<User_Role> user_Role, Entrenador entrenador) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.user_Role = user_Role;
		this.entrenador = entrenador;
	}

	public User() {}

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

	public Set<User_Role> getUser_Role() {
		return user_Role;
	}

	public void setUser_Role(Set<User_Role> user_Role) {
		this.user_Role = user_Role;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	
	
}






/*package com.pokemon.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Usuario {

	@Id
	@Column(name="username", unique=true, nullable=false, length=45)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String username;
	
	@Column(name="password", nullable=false, length=60)
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="usuario")
	private Set<User_Role> user_Role = new HashSet<User_Role>();

	@OneToOne
	@JoinColumn(name="entrenador")
	private Entrenador entrenador;

	public Usuario(String username, String password, boolean enabled, Set<User_Role> user_Role, Entrenador entrenador) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.user_Role = user_Role;
		this.entrenador = entrenador;
	}

	public Usuario() {}

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

	public Set<User_Role> getUser_Role() {
		return user_Role;
	}

	public void setUser_Role(Set<User_Role> user_Role) {
		this.user_Role = user_Role;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	
	
}*/