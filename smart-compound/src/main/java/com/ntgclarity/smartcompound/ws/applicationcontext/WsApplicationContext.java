package com.ntgclarity.smartcompound.ws.applicationcontext;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ntgclarity.smartcompound.ws.controller.AddressServiceController;
import com.ntgclarity.smartcompound.ws.controller.EmployeeController;
 
@ApplicationPath("/ws")
public class WsApplicationContext extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(EmployeeController.class);  	
		/**Heba's work start**/
		classes.add(AddressServiceController.class);
		/**Heba's work end**/
		return classes; 
		
	}

}
