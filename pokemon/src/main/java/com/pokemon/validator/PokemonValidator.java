package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.entity.Pokemon;


@Component
public class PokemonValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Pokemon.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Pokemon pokemon=(Pokemon)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","El campo nombre es obligatorio");
		
		
		if(pokemon.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre debe tener un tamaño menor que 50 caracteres");
		}
		
		
		
		
	}

}
