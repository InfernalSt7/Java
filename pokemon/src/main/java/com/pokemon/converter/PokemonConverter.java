package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.Pokemon;
import com.pokemon.model.PokemonModel;

@Component("pokemonConverter")
public class PokemonConverter {

	//Entity --> Model
    public PokemonModel entity2model(Pokemon pokemon) {
    	PokemonModel pokemonModel=new PokemonModel();
    	pokemonModel.setId(pokemon.getId());
    	pokemonModel.setNombre(pokemon.getNombre());
    	pokemonModel.setAtaque(pokemon.getAtaque());
    	pokemonModel.setDefensa(pokemon.getDefensa());
    	
        return pokemonModel;
    }
    
    public Pokemon model2entity(PokemonModel pokemonModel) {
    	Pokemon pokemon=new Pokemon();
    	pokemon.setId(pokemonModel.getId());
    	pokemon.setNombre(pokemonModel.getNombre());
    	pokemon.setAtaque(pokemonModel.getAtaque());
    	pokemon.setDefensa(pokemonModel.getDefensa());
    	
        return pokemon;
    }

}













/*package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.Pokemon;
import com.pokemon.model.PokemonModel;

@Component("pokemonConverter")
public class PokemonConverter {
	
	//Entity --> Model
	public PokemonModel entity2model(Pokemon pokemon) {
		PokemonModel pokemonModel=new PokemonModel();
		pokemonModel.setId(pokemon.getId());
		pokemonModel.setNombre(pokemon.getNombre());
		pokemonModel.setAtaque(pokemon.getAtaque());
		pokemonModel.setDefensa(pokemon.getDefensa());
		pokemonModel.setFoto(pokemon.getFoto());
		pokemonModel.setTipo(pokemon.getTipo());
		return pokemonModel;
	}
	
	public Pokemon model2entity(PokemonModel pokemonModel) {
		Pokemon pokemon=new Pokemon();
		pokemon.setId(pokemonModel.getId());
		pokemon.setNombre(pokemonModel.getNombre());
		pokemon.setAtaque(pokemonModel.getAtaque());
		pokemon.setDefensa(pokemonModel.getDefensa());
		pokemon.setFoto(pokemonModel.getFoto());
		pokemon.setTipo(pokemonModel.getTipo());
		return pokemon;
	}

}*/
