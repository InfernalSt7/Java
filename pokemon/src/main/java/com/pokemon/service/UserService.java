package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.User;
import com.pokemon.model.UserModel;

public interface UserService {
	
	//añadir usuario
	public com.pokemon.entity.User addUser(User user);
	
	//comprobar si existe el usuario
	public abstract boolean validateUser(String username);

	public List<UserModel> listUsers();

	public abstract UserModel transform(User user);
	
}
