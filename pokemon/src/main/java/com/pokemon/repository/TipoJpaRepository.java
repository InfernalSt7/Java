package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.Pokemon;
import com.pokemon.entity.Tipos;

@Repository("tipoRepository")
public interface TipoJpaRepository extends JpaRepository<Tipos, Serializable>{

	public abstract Tipos findById(int id);
	
}
