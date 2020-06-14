package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.converter.EquipoConverter;
import com.pokemon.entity.Equipo;
import com.pokemon.model.EquipoModel;
import com.pokemon.repository.EquipoJpaRepository;
import com.pokemon.service.EquipoService;

@Service("equipoServiceImpl")
public class EquipoServiceImpl implements EquipoService{
	
	@Autowired
	@Qualifier("equipoRepository")
	private EquipoJpaRepository equipoJpaRepository;
	
	@Autowired
	private DozerBeanMapper dozer;
	
	@Autowired
	@Qualifier("equipoConverter")
	private EquipoConverter equipoConverter;
	
	@Override
	public List<EquipoModel> listAllEquipos() {
		List<Equipo> listaEquipo=equipoJpaRepository.findAll();
		List<EquipoModel> listaEqModel=new ArrayList<>();
		listaEquipo.forEach(a->{
			EquipoModel equipoModel=transform(a);
			listaEqModel.add(equipoModel);
		});
		
		Collections.sort(listaEqModel, (EquipoModel eq1, EquipoModel eq2) -> eq1.getNombre().compareTo(eq2.getNombre()));
		
		return listaEqModel;
	}


	@Override
	public EquipoModel addEquipo(EquipoModel equipoModel) {
		Equipo equipo=transform(equipoModel);
		return transform(equipoJpaRepository.save(equipo));
		
	}

 
	@Override
	public EquipoModel updateEquipo(int id) {
		EquipoModel equipoModel = new EquipoModel();
        Equipo equipo = equipoJpaRepository.findById(id);
        equipoModel = equipoConverter.entity2model(equipo); // Esto es con el converter
        return equipoModel;
	}

	@Override
	public int removeEquipo(int id) {
		equipoJpaRepository.deleteById(id);
		return 0;
	}
	
	
	@Override
	public Equipo transform(EquipoModel equipoModel) {
		return dozer.map(equipoModel, Equipo.class);
	}
	
	@Override
	public EquipoModel transform(Equipo equipo) {
		return dozer.map(equipo, EquipoModel.class);
	}
	
}
