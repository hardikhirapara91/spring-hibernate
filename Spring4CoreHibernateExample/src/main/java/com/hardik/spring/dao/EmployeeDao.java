package com.hardik.spring.dao;

import java.util.List;

import com.hardik.spring.model.Employee;

/**
 * Employee DAO Interface
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface EmployeeDao {
	public List<Employee> getEmployees();

	public Employee getEmployeeById(Integer id);

	public void saveEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public void deleteEmployee(Integer id);
}
