package com.ntg.smartCompound.service;

import javax.ws.rs.core.Response;

import com.ntg.smartCompound.entity.User;

public interface ServiceInt {
	 public Response employeeDetailPrint();
	    
	 public User getUser();
	 
	 public void insertUser();
}
