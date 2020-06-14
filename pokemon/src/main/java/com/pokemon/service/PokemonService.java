package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.Pokemon;
import com.pokemon.model.PokemonModel;


public interface PokemonService {

	public abstract List<PokemonModel> listAllPokemons();
	public abstract PokemonModel addPokemon(PokemonModel pokemonModel);
	public abstract int removePokemon(int id);
	//public abstract PokemonModel updatePokemon(PokemonModel pokemonModel);  
	public abstract PokemonModel updatePokemon (int id); 
	public abstract PokemonModel transform(Pokemon pokemon);
	public abstract Pokemon transform(PokemonModel pokemonModel);
}
