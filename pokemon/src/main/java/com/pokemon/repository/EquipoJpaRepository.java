package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.Equipo;
import com.pokemon.entity.Pokemon;

@Repository("equipoRepository")
public interface EquipoJpaRepository extends JpaRepository<Equipo, Serializable>{

	public abstract Equipo findById(int id);
	
}
