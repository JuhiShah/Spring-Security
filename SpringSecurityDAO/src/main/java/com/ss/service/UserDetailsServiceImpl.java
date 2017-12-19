package com.ss.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ss.dao.UserDao;
import com.ss.model.Role;
import com.ss.model.User;
import com.ss.model.UserStatus;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("inside loadUserByUsername : service");
		
		User user = userDao.findUserByName(username);
		if(user != null){
			System.out.println(" user :: "+user);
			String password = user.getPassword();
			System.out.println("password :: "+password);
			boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
			
			//here user roles are populated
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role : user.getRoles()){
				System.out.println("role :: "+role);
				authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
			}
			//spring security user object
			org.springframework.security.core.userdetails.User securityUser = new org.springframework.security.core.userdetails.User(username, password, enabled, true, true, true, authorities); 	
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User not found !!");
		}
		
	}

}
