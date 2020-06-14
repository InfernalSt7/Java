package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.Competicion;
import com.pokemon.model.CompeticionModel;

public interface CompeticionService {

	public abstract List<CompeticionModel> listCompeticion();
	public abstract CompeticionModel addCompeticion(CompeticionModel competicionModel);
	public abstract int removeCompeticion(int id);
	public abstract CompeticionModel updateCompeticion(int id);
	public abstract Competicion transform(CompeticionModel competicionModel);
	public abstract CompeticionModel transform(Competicion competicion);
}
