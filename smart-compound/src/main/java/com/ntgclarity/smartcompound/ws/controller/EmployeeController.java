package com.ntgclarity.smartcompound.ws.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ntgclarity.smartcompound.common.entity.Employee;

@Path("/employeeController")
public class EmployeeController extends AbstractController {


	@GET
	@Path("/getAllEmployees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees() {
		return getSmartCompoundManagement().getAllEmployees();
	}

}
