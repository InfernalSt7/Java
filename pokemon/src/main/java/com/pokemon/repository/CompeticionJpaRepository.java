package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.Competicion;
import com.pokemon.entity.Pokemon;

@Repository("competicionRepository")
public interface CompeticionJpaRepository extends JpaRepository<Competicion, Serializable>{

	public abstract Competicion findById(int id);
}
