package com.ntgclarity.smartcompound.business.managementimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntgclarity.smartcompound.business.management.SmartCompoundManagment;
import com.ntgclarity.smartcompound.business.service.EmployeeService;
import com.ntgclarity.smartcompound.common.entity.Employee;

@Service
public class SmartCompoundManagmentImpl implements SmartCompoundManagment{

	@Autowired
	private EmployeeService employeeService;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}


	@Override
	public Employee getEmployee(Long id) {
		return employeeService.getEmployee(id);
	}

}
