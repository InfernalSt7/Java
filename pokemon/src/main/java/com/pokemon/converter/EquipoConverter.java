package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.Equipo;
import com.pokemon.model.EquipoModel;

@Component("equipoConverter")
public class EquipoConverter {

	
	//Entity --> Model
			public EquipoModel entity2model(Equipo equipo) {
				EquipoModel equipoModel=new EquipoModel();
				equipoModel.setId(equipo.getId());
				equipoModel.setNombre(equipo.getNombre());
				equipoModel.setDescripcion(equipo.getDescripcion());
				return equipoModel;
			}
			
			public Equipo model2entity(EquipoModel equipoModel) {
				Equipo equipo=new Equipo();
				equipo.setId(equipoModel.getId());
				equipo.setNombre(equipoModel.getNombre());
				equipo.setDescripcion(equipoModel.getDescripcion());
				return equipo;
			}
	
}
