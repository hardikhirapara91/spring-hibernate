package com.hardik.spring;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.hardik.spring.configuration.AppConfig;
import com.hardik.spring.model.Employee;
import com.hardik.spring.service.EmployeeService;

/**
 * Application Main Class
 *
 */
public class App {
	public static void main(String[] args) {

		// AbstractApplicationContext context = new
		// ClassPathXmlApplicationContext("app-config.xml");
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Employee Service
		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

		// Get all employees
		List<Employee> employees = employeeService.getAll();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		// Get employee by id
		Employee employee = employeeService.getById(1);
		System.out.println(employee);

		// Save employee
		Employee saveEmployee = new Employee();
		saveEmployee.setName("Hardik Hirapara");
		saveEmployee.setJoiningDate(new LocalDate(2010, 10, 10));
		saveEmployee.setSalary(new BigDecimal(1212121212.565656565));
		saveEmployee.setSsn("123A5BGH56");
		employeeService.save(saveEmployee);

		// Update employee
		Employee updtEmployee = new Employee();
		updtEmployee.setId(1);
		updtEmployee.setName("Hardik Patel");
		updtEmployee.setJoiningDate(new LocalDate(2010, 10, 10));
		updtEmployee.setSalary(new BigDecimal(1212121212.565656565));
		updtEmployee.setSsn("123A5BGH56");
		employeeService.update(updtEmployee);

		// Delete employee
		employeeService.delete(2);

		context.close();
	}
}
