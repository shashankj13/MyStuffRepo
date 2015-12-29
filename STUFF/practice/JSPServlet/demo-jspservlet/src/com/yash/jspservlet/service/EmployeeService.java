package com.yash.jspservlet.service;

import java.util.List;

import com.yash.jspservlet.dao.EmployeeDao;
import com.yash.jspservlet.domain.Employee;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();
		
	public List<Employee> fetchAllEmployee(){
		List<Employee> list = dao.getAllEmployee();
		System.out.println("IN SERVICE --------" +list);
		return list;
	}
	
	public void addEmployee(String name, String city){
		Employee employee = new Employee();
		employee.setName(name);
		employee.setCity(city);
		dao.addEmployee(employee);
	}

	public List<Employee> updateEmployee(String name, String city, int id) {
		List<Employee> list = dao.getAllEmployee();
		Employee employee = new Employee();
		employee.setName(name);
		employee.setCity(city);
		employee.setEmployeeId(id);
		dao.updateEmployeeDetails(employee);
		return list;
	}

	public void delEmployee(int id) {
		Employee employee = new Employee();
		employee.setEmployeeId(id);
		dao.deleteEmployee(employee);
	}

}
