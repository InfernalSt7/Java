package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.Pokemon;
import com.pokemon.model.PokemonModel;

@Repository("pokemonRepository")
public interface PokemonJpaRepository extends JpaRepository<Pokemon, Serializable>{

	public abstract Pokemon findById(int id);
	
}
