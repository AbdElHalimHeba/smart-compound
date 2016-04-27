package com.ntgclarity.smartcompound.dataaccess.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ntgclarity.smartcompound.common.entity.Employee;
import com.ntgclarity.smartcompound.dataaccess.base.BaseDAO;
import com.ntgclarity.smartcompound.dataaccess.dao.EmployeeDAO;

@Repository
public class EmployeeDAOImpl extends BaseDAO implements EmployeeDAO {

	@Override
	public List<Employee> getAllEmployees() {

		return (List<Employee>) super.getAll(Employee.class);
	}

	@Override
	public Employee getEmployee(Long id) {
		return  (Employee) super.get(Employee.class , id);
	}

}
