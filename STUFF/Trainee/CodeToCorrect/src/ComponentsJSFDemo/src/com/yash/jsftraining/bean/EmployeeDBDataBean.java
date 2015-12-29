package ComponentsJSFDemo.src.com.yash.jsftraining.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ComponentsJSFDemo.src.com.yash.training.service.EmployeeServiceIntf;

@ManagedBean
@RequestScoped
public class EmployeeDBDataBean {
	
	private List<EmployeeDB> employeeList;
	
	@EJB
	//1. this will create the object of implementation in EJB container
	//2. this will link or inject the implementation object in EmployeeServiceIntf reference
	private EmployeeServiceIntf employeeService;
	
	@PostConstruct
	public void init(){
		try {
			employeeList=employeeService.getAllEmployees();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public List<EmployeeDB> getEmployeeList() throws Exception {
		employeeList=employeeService.getAllEmployees();
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeDB> employeeList) {
		this.employeeList = employeeList;
	}
	
	public String removeEmployee(int empId){
		try {
			employeeService.deleteEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "*";
	}

}
