package com.pokemon.service.impl;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pokemon.entity.User_Role;
import com.pokemon.repository.User_RoleRepository;
import com.pokemon.service.User_RoleService;

@Service
public class UserRoleServiceImpl implements User_RoleService {
    
    @Autowired
    @Qualifier("userRoleRepository")
    private User_RoleRepository userRoleRepository;
    
    @Autowired
	private DozerBeanMapper dozer;
    
    @Override
    public List<User_Role> getListUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
	public User_Role addUser(User_Role user_Role) {
		return userRoleRepository.save(user_Role);
	}


}