package com.pokemon.converter;

import org.springframework.stereotype.Component;

import com.pokemon.entity.Movimiento;
import com.pokemon.model.MovimientoModel;

@Component("movimientoConverter")
public class MovimientoConverter {

	//Entity --> Model
			public MovimientoModel entity2model(Movimiento movimiento) {
				MovimientoModel movimientoModel=new MovimientoModel();
				movimientoModel.setId(movimiento.getId());
				movimientoModel.setNombre(movimiento.getNombre());
				movimientoModel.setCategoria(movimiento.getCategoria());
				movimientoModel.setDescripcion(movimiento.getDescripcion());
				movimientoModel.setPotencia(movimiento.getPotencia());
				movimientoModel.setPrecission(movimiento.getPrecission());

				return movimientoModel;
			}
			
			public Movimiento model2entity(MovimientoModel movimientoModel) {
				Movimiento movimiento=new Movimiento();
				movimiento.setId(movimientoModel.getId());
				movimiento.setNombre(movimientoModel.getNombre());
				movimiento.setCategoria(movimientoModel.getCategoria());
				movimiento.setDescripcion(movimientoModel.getDescripcion());
				movimiento.setPotencia(movimientoModel.getPotencia());
				movimiento.setPrecission(movimientoModel.getPrecission());
				return movimiento;
			}
	
}
