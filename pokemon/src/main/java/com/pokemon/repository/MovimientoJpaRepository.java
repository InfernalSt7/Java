package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.Movimiento;
import com.pokemon.entity.Pokemon;

@Repository("movimientoRepository")
public interface MovimientoJpaRepository extends JpaRepository<Movimiento, Serializable>{

	public abstract Movimiento findById(int id);
	
}
