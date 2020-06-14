package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.TipoConverter;
import com.pokemon.entity.Tipos;
import com.pokemon.model.TipoModel;
import com.pokemon.repository.TipoJpaRepository;
import com.pokemon.service.TipoService;

@Service("tipoServiceImpl")
public class TipoServiceImpl implements TipoService{
	
	@Autowired
	@Qualifier("tipoRepository")
	private TipoJpaRepository tipoJpaRepository;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	@Qualifier("tipoConverter")
	private TipoConverter tipoConverter;
	
	@Override
	public List<TipoModel> listAllTipos() {
		List<Tipos> listaTipo=tipoJpaRepository.findAll();
		List<TipoModel> listaTModel=new ArrayList<>();
		listaTipo.forEach(a->{
			TipoModel tipoModel=transform(a);
			listaTModel.add(tipoModel);
		});
		
		Collections.sort(listaTModel, (TipoModel t1, TipoModel t2) -> t1.getNombre().compareTo(t2.getNombre()));
		
		return listaTModel;
	}


	@Override
	public TipoModel addTipo(TipoModel tipoModel) {
		Tipos tipos=transform(tipoModel);
		return transform(tipoJpaRepository.save(tipos));
		
	}

 
	@Override
	public TipoModel updateTipo(int id) {
		TipoModel tipoModel = new TipoModel();
        Tipos tipo= tipoJpaRepository.findById(id);
        tipoModel = tipoConverter.entity2model(tipo); // Esto es con el converter
        return tipoModel;

	}

	@Override
	public int removeTipo(int id) {
		tipoJpaRepository.deleteById(id);
		return 0;
	}
	
	
	@Override
	public Tipos transform(TipoModel tipoModel) {
		return dozer.map(tipoModel, Tipos.class);
	}
	
	@Override
	public TipoModel transform(Tipos tipos) {
		return dozer.map(tipos, TipoModel.class);
	}
	
}
