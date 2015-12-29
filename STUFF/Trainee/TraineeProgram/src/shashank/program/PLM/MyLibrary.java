package shashank.program.PLM;

import java.util.ArrayList;
import java.util.Scanner;

public class MyLibrary {
	
	ArrayList<String> list ;
	ArrayList<String> listPerson = new ArrayList<String>();
	private Scanner k ;
	private Scanner k1 ;
	private Scanner k2 ;
	private Scanner k3 ;
	private String input;
	private String inputPerson;
	private String bookRemove;
	private String personRemove;

	/*
	1: checkout (Book issue)
	2: checkIn (Book return)
	3: add book
	4: remove book
	5: add person
	6: remove person
	7: get available books for person
	8: available books
	 */
	
	public void addBook(){
		System.out.println("Enter Book Name");
		k=new Scanner(System.in);
		input = k.next();
			 list.add(input);
			 System.out.println("New List Of Books Is: "+ list);
	}
		
	
	public void removeBook(){
		System.out.println("Enter The Book You Want TO delete");
		k1 = new Scanner(System.in);
		bookRemove = k1.next();
		list.remove(bookRemove);
		System.out.println("The arraylist contains the following elements: "+ list);
	}
	
	public void addPerson(){
		System.out.println("Enter Your Name");
		k2=new Scanner(System.in);
		inputPerson = k2.next();
			 listPerson.add(inputPerson);
			 System.out.println("New List Of Person Is: "+ listPerson);
	}
	public void removePerson(){
		System.out.println("Enter Your Name");
		k3 = new Scanner(System.in);
		personRemove = k3.next();
		listPerson.remove(personRemove);
		System.out.println("The arraylist contains the following elements: "+ listPerson);
	}	
	
			 
	
	 public void availableBooks(){
		 System.out.println("THE AVAILABLE BOOKS ARE");
		 list = new ArrayList<String>();
		 list.add("c++1");
		 list.add("c++2");
		 list.add("c++3");
		 list.add("c++4");
		 list.add("c++5");
		 list.add("C1");
		 list.add("C2");
		 list.add("C3");
		 list.add("C4");
		 list.add("C5");
		 list.add("Java1");
		 list.add("Java2");
		 list.add("Java3");
		 list.add("Java4");
		 list.add("Java5");
		 System.out.println("The arraylist contains the following elements: "+ list);
	 }
	 
	 public void availablePerson(){
		 listPerson = new ArrayList<String>();
		 System.out.println("The arraylist contains the following elements: "+ listPerson);
	 }

}
