package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.Tipos;
import com.pokemon.model.TipoModel;


public interface TipoService {

	public abstract List<TipoModel> listAllTipos();
	public abstract TipoModel addTipo(TipoModel tipoModel);
	public abstract int removeTipo(int id);
	public abstract TipoModel updateTipo(int id);
	public abstract Tipos transform(TipoModel tipoModel);
	public abstract TipoModel transform(Tipos tipos);
}
