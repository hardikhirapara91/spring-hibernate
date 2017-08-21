package com.hardik.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hardik.spring.dao.EmployeeDao;
import com.hardik.spring.model.Employee;

/**
 * Employee Service Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public EmployeeDao employeeDao;

	/**
	 * Get All
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAll() {
		try {
			return employeeDao.getEmployees();
		} catch (Exception ex) {
			System.out.println("Exception: EmployeeServiceImpl.getAll() : " + ex);
		}

		return new ArrayList<>();
	}

	/**
	 * Get by Id
	 */
	@Override
	@Transactional(readOnly = true)
	public Employee getById(Integer id) {
		try {
			return employeeDao.getEmployeeById(id);
		} catch (Exception ex) {
			System.out.println("Exception: EmployeeServiceImpl.getById() : " + ex);
		}
		return new Employee();
	}

	/**
	 * Save
	 */
	@Override
	public void save(Employee employee) {
		try {
			employeeDao.saveEmployee(employee);
			System.out.println("Record inserted successfully.");
		} catch (Exception ex) {
			System.out.println("Exception: EmployeeServiceImpl.save() : " + ex);
		}
	}

	/**
	 * Update
	 */
	@Override
	public void update(Employee employee) {
		try {
			employeeDao.updateEmployee(employee);
			System.out.println("Record updated successfully.");
		} catch (Exception ex) {
			System.out.println("Exception: EmployeeServiceImpl.update() : " + ex);
		}
	}

	/**
	 * Delete
	 */
	@Override
	public void delete(Integer id) {
		try {
			employeeDao.deleteEmployee(id);
			System.out.println("Record deleted successfully.");
		} catch (Exception ex) {
			System.out.println("Exception: EmployeeServiceImpl.delete() : " + ex);
		}
	}

}
