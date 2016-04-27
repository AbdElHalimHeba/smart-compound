package com.ntgclarity.smartcompound.portal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder amb) {
		amb.authenticationProvider(customAuthenticationProvider);
	}

	@Configuration
	public static class MyClass1 extends WebSecurityConfigurerAdapter {

		@Autowired
		private CustomAccessDescionManager customAccesDescionManager;

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();   
//			http.authorizeRequests().antMatchers("/login.xhtml").permitAll()
//					.and().formLogin().loginPage("/login.html").permitAll()
//					.and().logout().permitAll().logoutSuccessUrl("/login.html")
//					.and().authorizeRequests().antMatchers("/admin/**").hasAuthority("admin")
//					.anyRequest().fullyAuthenticated().and().formLogin()
//					.loginPage("/login.xhtml").failureUrl("/login?error")
//					.usernameParameter("email").permitAll().and().logout()
//					.logoutUrl("/logout").deleteCookies("remember-me")
//					.logoutSuccessUrl("/").permitAll().and().rememberMe(); 
		}

		@Override
		public void configure(WebSecurity web) throws Exception {
			// TODO Auto-generated method stub
			web.ignoring().antMatchers("/javax.faces.resource/**");
			web.ignoring().antMatchers("/*.xhtml"); 

		}
	}

}
