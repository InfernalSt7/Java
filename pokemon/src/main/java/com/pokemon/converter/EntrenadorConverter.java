package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.Entrenador;
import com.pokemon.model.EntrenadorModel;

@Component("entrenadorConverter")
public class EntrenadorConverter {

	//Entity --> Model
		public EntrenadorModel entity2model(Entrenador entrenador) {
			EntrenadorModel entrenadorModel=new EntrenadorModel();
			entrenadorModel.setId(entrenador.getId());
			entrenadorModel.setNombre(entrenador.getNombre());
			entrenadorModel.setFoto(entrenador.getFoto());
			entrenadorModel.setTelefono(entrenador.getTelefono());
			entrenadorModel.setEmail(entrenador.getEmail());
			entrenadorModel.setUser(entrenador.getUser());
			entrenadorModel.setEquipo(entrenador.getEquipo());
			return entrenadorModel;
		}
		
		public Entrenador model2entity(EntrenadorModel entrenadorModel) {
			Entrenador entrenador=new Entrenador();
			entrenador.setId(entrenadorModel.getId());
			entrenador.setNombre(entrenadorModel.getNombre());
			entrenador.setFoto(entrenadorModel.getFoto());
			entrenador.setTelefono(entrenadorModel.getTelefono());
			entrenador.setEmail(entrenadorModel.getEmail());
			entrenador.setUser(entrenadorModel.getUser());
			entrenador.setEquipo(entrenadorModel.getEquipo());
			return entrenador;
		}
	
}
