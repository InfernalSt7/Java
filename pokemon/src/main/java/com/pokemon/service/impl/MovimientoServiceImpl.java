package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.MovimientoConverter;
import com.pokemon.entity.Movimiento;
import com.pokemon.model.MovimientoModel;
import com.pokemon.repository.MovimientoJpaRepository;
import com.pokemon.service.MovimientoService;

@Service("movimientoServiceImpl")
public class MovimientoServiceImpl implements MovimientoService{
	
	@Autowired
	@Qualifier("movimientoRepository")
	private MovimientoJpaRepository movimientoJpaRepository;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	@Qualifier("movimientoConverter")
	private MovimientoConverter movimientoConverter;
	
	@Override
	public List<MovimientoModel> listAllMovimientos() {
		List<Movimiento> listaMovimiento=movimientoJpaRepository.findAll();
		List<MovimientoModel> listaMModel=new ArrayList<>();
		listaMovimiento.forEach(a->{
			MovimientoModel movimientoModel=transform(a);
			listaMModel.add(movimientoModel);
		});
		
		Collections.sort(listaMModel, (MovimientoModel m1, MovimientoModel m2) -> m1.getNombre().compareTo(m2.getNombre()));
		
		return listaMModel;
	}


	@Override
	public MovimientoModel addMovimiento(MovimientoModel movimientoModel) {
		Movimiento movimiento=transform(movimientoModel);
		return transform(movimientoJpaRepository.save(movimiento));
		
	}

 
	@Override
	public MovimientoModel updateMovimiento(int id) {
		MovimientoModel movimientoModel = new MovimientoModel();
        Movimiento movimiento= movimientoJpaRepository.findById(id);
        movimientoModel = movimientoConverter.entity2model(movimiento); // Esto es con el converter
        return movimientoModel;
	}

	@Override
	public int removeMovimiento(int id) {
		movimientoJpaRepository.deleteById(id);
		return 0;
	}
	
	
	@Override
	public Movimiento transform(MovimientoModel movimientoModel) {
		return dozer.map(movimientoModel, Movimiento.class);
	}
	
	@Override
	public MovimientoModel transform(Movimiento movimiento) {
		return dozer.map(movimiento, MovimientoModel.class);
	}
	
}
