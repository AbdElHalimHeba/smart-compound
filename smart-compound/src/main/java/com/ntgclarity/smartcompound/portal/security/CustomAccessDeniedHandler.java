package com.ntgclarity.smartcompound.portal.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessDeniedHandler extends AccessDeniedHandlerImpl {
	private final String HOME_PAGE = "/index.xhtml";

	@Override
	public void handle(HttpServletRequest request,
			HttpServletResponse response, AccessDeniedException e)
			throws IOException, ServletException {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
			response.sendRedirect(HOME_PAGE);
		}

		super.handle(request, response, e);
	}
}