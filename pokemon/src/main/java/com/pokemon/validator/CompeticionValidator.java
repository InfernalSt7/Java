package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.entity.Competicion;


@Component
public class CompeticionValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Competicion.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Competicion competicion=(Competicion)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","Es obligatorio el nombre de la competicion");
		
		
		if(competicion.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre debe tener un tamaño menor que 50 caracteres");
		}
		
		if(competicion.getFecha().length()<3) {
			errors.rejectValue("fecha", "fecha.incorrect", "La fecha ha sido introducida de forma incorrecta");
		}
		
		if(competicion.getLugar().length()<4) {
			errors.rejectValue("lugar", "luga.incorrect", "El lugar debe tener más de 4 caracteres");
		}
		
		
	}

}
