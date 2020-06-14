package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.PokemonConverter;
import com.pokemon.entity.Pokemon;
import com.pokemon.model.PokemonModel;
import com.pokemon.repository.PokemonJpaRepository;
import com.pokemon.service.PokemonService;

@Service("pokemonServiceImpl")
public class PokemonServiceImpl implements PokemonService{
	
	@Autowired
	@Qualifier("pokemonRepository")
	private PokemonJpaRepository pokemonJpaRepository;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	@Qualifier("pokemonConverter")
	private PokemonConverter pokemonConverter;
	
	@Override
	public List<PokemonModel> listAllPokemons() {
		List<Pokemon> listaPokemon=pokemonJpaRepository.findAll();
		List<PokemonModel> listaPModel=new ArrayList<>();
		listaPokemon.forEach(a->{
			PokemonModel pokemonModel=transform(a);
			listaPModel.add(pokemonModel);
		});
		
		//Collections.sort(listaPModel, (PokemonModel p1, PokemonModel p2) -> p1.getNombre().compareTo(p2.getNombre()));
		
		return listaPModel;
	}


	@Override
	public PokemonModel addPokemon(PokemonModel pokemonModel) {
		Pokemon pokemon=transform(pokemonModel);
		return transform(pokemonJpaRepository.save(pokemon));
		
	}

	
	@Override
    public PokemonModel updatePokemon(int id){
		PokemonModel pokemonModel = new PokemonModel();
        Pokemon pokemon = pokemonJpaRepository.findById(id);
        pokemonModel = pokemonConverter.entity2model(pokemon); // Esto es con el converter
        return pokemonModel;
    } 
 
	/*@Override
	public PokemonModel updatePokemon(PokemonModel pokemonModel) {
		Pokemon pokemon=transform(pokemonModel);
		return transform(pokemonJpaRepository.save(pokemon));
	} */

	@Override
	public int removePokemon(int id) {
		pokemonJpaRepository.deleteById(id);
		return 0;
	}
	
	
	@Override
	public Pokemon transform(PokemonModel pokemonModel) {
		return dozer.map(pokemonModel, Pokemon.class);
	}
	
	@Override
	public PokemonModel transform(Pokemon pokemon) {
		return dozer.map(pokemon, PokemonModel.class);
	}

 

	
}
