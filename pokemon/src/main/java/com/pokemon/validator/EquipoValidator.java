package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.entity.Equipo;


@Component
public class EquipoValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Equipo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Equipo equipo=(Equipo)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","El campo nombre es obligatorio");
		
		
		if(equipo.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre debe tener un tamaño menor que 50 caracteres");
		}
		
		if(equipo.getDescripcion().length()<150) {
			errors.rejectValue("descripcion", "descripcion.incorrect", "La descripcion debe tener un tamaño mayor que 500 caracteres");
		}
		
		
		
		
	}

}
