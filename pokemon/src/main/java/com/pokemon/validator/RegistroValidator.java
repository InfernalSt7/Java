package com.pokemon.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pokemon.entity.User;


@Component
public class RegistroValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user=(User)target;
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "required.nombre","El campo nombre es obligatorio");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contraseña", "required.contraseña","El campo contraseña es obligatorio");
		
		if(user.getUsername().length()>50) {
			errors.rejectValue("nombre", "nombre.incorrect", "El nombre debe tener un tamaño menor que 50 caracteres");
		}
		
		if(user.getPassword().length()>500) {
			errors.rejectValue("contraseña", "contraseña.incorrect", "La contraseña debe tener un tamaño menor que 500 caracteres");
		}
		
		if(user.getPassword().length()<4) {
			errors.rejectValue("contraseña", "contraseña.incorrect", "La contraseña debe tener más de 4 caracteres");
		}
		
		
	}

}
