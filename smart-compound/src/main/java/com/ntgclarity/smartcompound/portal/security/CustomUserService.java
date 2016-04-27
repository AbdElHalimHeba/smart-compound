package com.ntgclarity.smartcompound.portal.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component 
public class CustomUserService implements UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return null;
	}
}
