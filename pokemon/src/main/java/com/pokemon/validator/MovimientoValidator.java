package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.entity.Movimiento;


@Component
public class MovimientoValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Movimiento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Movimiento movimiento=(Movimiento)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","El campo nombre es obligatorio");
		
		
		if(movimiento.getNombre().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre debe tener un tamaño menor que 50 caracteres");
		}
		
		if(movimiento.getDescripcion().length()<150) {
			errors.rejectValue("descripcion", "descripcion.incorrect", "La descripción debe tener un tamaño mayor que 150 caracteres");
		}
		
		if(movimiento.getCategoria().length()<4) {
			errors.rejectValue("categoria", "categoria.incorrect", "La categoría debe tener más de 4 caracteres");
		}		
		
	}

}
