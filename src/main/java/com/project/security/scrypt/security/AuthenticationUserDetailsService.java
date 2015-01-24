package com.project.security.scrypt.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.security.scrypt.model.Person;
import com.project.security.scrypt.repository.PersonRepository;


/**
 * @author Yvau
 *
 */
@Service("userDetailsService")
@Transactional(readOnly = true)
public class AuthenticationUserDetailsService implements UserDetailsService {
	
	@Autowired
    private PersonRepository userRepository;


	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Person user = userRepository.findByUsername(username);
			
			List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
	    	role.add(new SimpleGrantedAuthority("ROLE_USER"));

			if(user==null) {throw new UsernameNotFoundException("No such user: " + username);} 
			
			
			return new org.springframework.security.core.userdetails.User(
					user.getUsername(),
					user.getPassword(),
					true,
					true,
					true,
					true,role);
		
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
