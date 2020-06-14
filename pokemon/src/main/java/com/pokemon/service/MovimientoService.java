package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.Movimiento;
import com.pokemon.model.MovimientoModel;


public interface MovimientoService {

	public abstract List<MovimientoModel> listAllMovimientos();
	public abstract MovimientoModel addMovimiento(MovimientoModel movimientoModel);
	public abstract int removeMovimiento(int id);
	public abstract MovimientoModel updateMovimiento(int id);
	public abstract MovimientoModel transform(Movimiento movimiento);
	public abstract Movimiento transform(MovimientoModel movimientoModel);
}
