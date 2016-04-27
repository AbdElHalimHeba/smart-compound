package com.ntgclarity.smartcompound.portal.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private CustomUserService userService;

	
	public boolean supports(Class<?> arg0) {
		return true;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		System.out.println("well additional authetication run successfully");
	}
  
	@Override
	protected UserDetails retrieveUser(String username,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		CustomUserDetails userDetails = new CustomUserDetails();
		userDetails.setAuthorities(new ArrayList<Role>());
		userDetails.getAuthorities().add(new Role("admin"));
		return userDetails;
	}

}