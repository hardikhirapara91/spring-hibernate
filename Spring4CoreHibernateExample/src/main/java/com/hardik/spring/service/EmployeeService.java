package com.hardik.spring.service;

import java.util.List;

import com.hardik.spring.model.Employee;

/**
 * Employee Service Interface
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface EmployeeService {
	public List<Employee> getAll();

	public Employee getById(Integer id);

	public void save(Employee employee);

	public void update(Employee employee);

	public void delete(Integer id);
}
