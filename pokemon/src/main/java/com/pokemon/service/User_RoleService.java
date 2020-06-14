package com.pokemon.service;

import java.util.List;

import com.pokemon.entity.User_Role;



public interface User_RoleService {
		public abstract List<User_Role> getListUsers();
	
		public abstract User_Role addUser(User_Role user_Role);

}
