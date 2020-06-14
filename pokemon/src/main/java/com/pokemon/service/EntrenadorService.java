package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.Entrenador;
import com.pokemon.model.EntrenadorModel;

public interface EntrenadorService {

	public abstract List<EntrenadorModel> listAllEntrenadores();
	public abstract EntrenadorModel addEntrenador(EntrenadorModel entrenadorModel);
	public abstract int removeEntrenador(int id);
	public abstract EntrenadorModel updateEntrenador(int id);
	public abstract EntrenadorModel transform(Entrenador entrenador);
	public abstract Entrenador transform(EntrenadorModel entrenadorModel);
	
}
