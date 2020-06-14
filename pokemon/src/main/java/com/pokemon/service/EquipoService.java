package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.Equipo;
import com.pokemon.model.EquipoModel;


public interface EquipoService {

	public abstract List<EquipoModel> listAllEquipos();
	public abstract EquipoModel addEquipo(EquipoModel equipoModel);
	public abstract int removeEquipo(int id);
	public abstract EquipoModel updateEquipo(int id);
	public abstract Equipo transform(EquipoModel equipoModel);
	public abstract EquipoModel transform(Equipo equipo);
}
