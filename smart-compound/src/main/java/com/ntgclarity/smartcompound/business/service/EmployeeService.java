package com.ntgclarity.smartcompound.business.service;

import java.util.List;

import com.ntgclarity.smartcompound.common.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

}
