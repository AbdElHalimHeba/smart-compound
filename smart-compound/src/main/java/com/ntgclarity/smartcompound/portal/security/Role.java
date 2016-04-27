package com.ntgclarity.smartcompound.portal.security;

import org.springframework.security.core.GrantedAuthority;
 
public class Role implements GrantedAuthority{
    
	public Role()
	{
		
	}
	
    public Role(String name) {
		super();
		this.name = name;
	}

	private String name;
     
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAuthority() {
        return this.name;
    }
}