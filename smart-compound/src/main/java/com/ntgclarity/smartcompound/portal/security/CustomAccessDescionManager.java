package com.ntgclarity.smartcompound.portal.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDescionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		System.out.println("xxxxxxxxxxxxxxxxxxx");

	}

	@Override
	public boolean supports(ConfigAttribute attribute) {

		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {

		return true;
	}

}
