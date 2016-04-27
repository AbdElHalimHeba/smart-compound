package com.ntgclarity.smartcompound.dataaccess.dao;

import java.util.List;

import com.ntgclarity.smartcompound.common.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

}
