package ComponentsJSFDemo.src.com.yash.jsftraining.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class UserBean {
	private String name;
	private int salary;
	private String password;
	private String address;
	private String email;
	private boolean mailMe;
	private int[] selectTechologies;
	
	
	
	public int[] getSelectTechologies() {
		return selectTechologies;
	}
	public void setSelectTechologies(int[] selectTechologies) {
		this.selectTechologies = selectTechologies;
	}
	public boolean isMailMe() {
		return mailMe;
	}
	public void setMailMe(boolean mailMe) {
		this.mailMe = mailMe;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String saveUser(){
		// Logic to save user in DB
		System.out.println("User saved..."+name);
		return null;
	}
	
	public void myMethod(ActionEvent e){
		// Logic to save user in DB
		System.out.println("User saved..."+name);
	}
	
	public void emailValidation(FacesContext context,UIComponent toValidate, Object value) throws ValidatorException{
		String emailStr=(String)value;
		if(emailStr.indexOf('@')<0){
				FacesMessage message=new FacesMessage("Invalid Email Address Format");
				throw new ValidatorException(message);
		}

	}
	
	public String mySelectedTechnologies(){
		StringBuilder sb=new StringBuilder();
		for(int i:selectTechologies){
			sb.append(" "+i);
		}
		
		return sb.toString();
	}
	
}
