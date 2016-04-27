package com.ntgclarity.smartcompound.portal.managedbean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ntgclarity.smartcompound.portal.base.BaseBean;
import com.ntgclarity.smartcompound.portal.utils.WebUtils;

@ManagedBean
@ViewScoped
public class LoginBean extends BaseBean implements Serializable {

	@ManagedProperty(value = "#{customAuthenticationProvider}")
	private AuthenticationProvider authenticationProvider;

	private String userName;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

	public void login() {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userName, password);

		Authentication authentcation = authenticationProvider
				.authenticate(usernamePasswordAuthenticationToken);

		SecurityContextHolder.getContext().setAuthentication(authentcation);
		WebUtils.injectIntoSession("SPRING_SECURITY_CONTEXT",
				SecurityContextHolder.getContext());

		addInfoMessage("you have been successfully authenticated");
		System.out.println();

	}

	public AuthenticationProvider getAuthenticationProvider() {
		return authenticationProvider;
	}

	public void setAuthenticationProvider(
			AuthenticationProvider authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}
}