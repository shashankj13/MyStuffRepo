package com.yash.serializedemo;

import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	   public String name;
	   public String address;
	   public transient int SSN;
	   public int number;
	   private static final Employee emp = new Employee();
	   
	   private Employee(){
		   
	   }
	   
	   public static Employee getEmpObject(){
		   	return emp;
	   }
	   
	   public void mailCheck()
	   {
	      System.out.println("Mailing a check to " + name + " " + address);
	   }
	   
	   private Object readResolve() throws ObjectStreamException{
			   	return emp;
	   }
	   
	   

}
