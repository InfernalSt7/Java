package com.pokemon.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pokemon.entity.User_Role;
import com.pokemon.model.UserModel;
import com.pokemon.repository.UserRepository;
import com.pokemon.service.UserService;


@Service("userServiceImpl")
public class UserServiceImpl implements UserDetailsService, UserService{
	
	private User buildUser(com.pokemon.entity.User user,
		List<GrantedAuthority> authorities) {
	return new User(user.getUsername(),user.getPassword(),user.isEnabled(),true,true,true,authorities);
	}
	
	private List<GrantedAuthority> buildAuthorities(Set<User_Role> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for(User_Role user_Role: userRoles) {
			auths.add(new SimpleGrantedAuthority(user_Role.getRole()));
		}
		
		return new ArrayList<GrantedAuthority>(auths);
	}

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	private DozerBeanMapper dozer;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.pokemon.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUser_Role());	
		return buildUser(user, authorities);
	}
	


	@Override
	public com.pokemon.entity.User addUser(com.pokemon.entity.User user) {
		user.setEnabled(true);
        return userRepository.save(user);
	}

	@Override
	public boolean validateUser(String username) {
		boolean flag=false;
		List<UserModel> listUsers=listUsers();
		
		for(UserModel um: listUsers) {
			System.out.println(um.getUsername());
			if(um.getUsername().equals(username)) {
				System.out.println("Coinciden");
				flag=true;
			}
		
			
		}
		
		return flag;
	}
	
	@Override
	public List<UserModel> listUsers() {
		List<com.pokemon.entity.User> listaUsers=userRepository.findAll();
		List<UserModel> listaUserModel=new ArrayList<>();
		listaUsers.forEach(a->{
			UserModel userModel=transform(a);
			listaUserModel.add(userModel);
		});
		
		Collections.sort(listaUserModel, (UserModel user1, UserModel user2) -> user1.getUsername().compareTo(user2.getUsername()));
		
		return listaUserModel;
	}


	@Override
	public UserModel transform(com.pokemon.entity.User user) {
		return dozer.map(user, UserModel.class);
	}
	

	

	
	
	

}
