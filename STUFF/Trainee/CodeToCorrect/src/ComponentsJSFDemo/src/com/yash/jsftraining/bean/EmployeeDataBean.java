package ComponentsJSFDemo.src.com.yash.jsftraining.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped

public class EmployeeDataBean {
	private List<Employee> employeeList;
	@PostConstruct
	public void init(){
		employeeList=new ArrayList<Employee>();
		employeeList.add(new Employee(101, "Pankaj", "Training"));
		employeeList.add(new Employee(102, "Dinesh", "Training"));
		employeeList.add(new Employee(103, "Nikhil", "Training"));
		employeeList.add(new Employee(104, "Narendra", "Training"));
		employeeList.add(new Employee(105, "Rakesh", "Project Management"));
		employeeList.add(new Employee(106, "Aman", "Development"));
		
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	

}
