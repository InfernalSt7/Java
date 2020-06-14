package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.Entrenador;
import com.pokemon.entity.Pokemon;

@Repository("entrenadorRepository")
public interface EntrenadorJpaRepository extends JpaRepository<Entrenador, Serializable>{

	public abstract Entrenador findById(int id);
	
}
