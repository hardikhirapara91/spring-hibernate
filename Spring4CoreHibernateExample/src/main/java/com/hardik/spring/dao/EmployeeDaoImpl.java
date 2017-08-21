package com.hardik.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hardik.spring.model.Employee;

/**
 * Employee DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	/**
	 * Get All Employee
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return criteria.list();
	}

	/**
	 * Get Employee by Id
	 */
	@Override
	public Employee getEmployeeById(Integer id) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id", id));
		return (Employee) criteria.uniqueResult();
	}

	/**
	 * Save Employee
	 */
	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	/**
	 * Update Employee
	 */
	@Override
	public void updateEmployee(Employee employee) {
		update(employee);
	}

	/**
	 * Delete Employee
	 */
	@Override
	public void deleteEmployee(Integer id) {
		Query query = getSession().createQuery("DELETE FROM Employee WHERE id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
