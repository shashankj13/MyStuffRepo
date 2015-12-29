package ComponentsJSFDemo.src.com.yash.training.service;

import java.util.List;
import javax.ejb.Local;

import ComponentsJSFDemo.src.com.yash.jsftraining.bean.EmployeeDB;

@Local
public interface EmployeeServiceIntf {
	
	public List<EmployeeDB> getAllEmployees() throws Exception;
	
	public void deleteEmployee(int empid) throws Exception;

}
