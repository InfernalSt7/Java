package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.Tipos;
import com.pokemon.model.TipoModel;

@Component("tipoConverter")
public class TipoConverter {

	//Entity --> Model
		public TipoModel entity2model(Tipos tipo) {
			TipoModel tipoModel=new TipoModel();
			tipoModel.setId(tipo.getId());
			tipoModel.setNombre(tipo.getNombre());
			return tipoModel;
		}
		
		public Tipos model2entity(TipoModel tipoModel) {
			Tipos tipo=new Tipos();
			tipo.setId(tipoModel.getId());
			tipo.setNombre(tipoModel.getNombre());
			return tipo;
		}
	
}
