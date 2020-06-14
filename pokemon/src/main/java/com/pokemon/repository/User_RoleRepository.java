package com.pokemon.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.entity.User_Role;

@Repository("userRoleRepository")
public interface User_RoleRepository extends JpaRepository <User_Role, Serializable>{
	public abstract User_Role findByUser (String username);
}
