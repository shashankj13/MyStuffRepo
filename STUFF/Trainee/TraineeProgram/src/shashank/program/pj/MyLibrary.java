 
package shashank.program.pj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class MyLibrary {
private Book book;
private Person person;
Set<Person> persons=new HashSet<Person>();
Set<Book> books=new HashSet<Book>();
Scanner sc=new Scanner(System.in);
// method to add a person in system

public void addPerson(){
	System.out.println("Enter Person's ID");
	int id=sc.nextInt();
	System.out.println("Enter Person's Name");
	String name=sc.next();
	System.out.println("Enter Maximum Book Count");
	int maxBookCount=sc.nextInt();
	persons.add(new Person(id,name,maxBookCount));
}
// method to add book in system
public void addBook(){
	System.out.println("Enter Book's ID");
	int id=sc.nextInt();
	System.out.println("Enter Book's Title");
	String title=sc.next();
	System.out.println("Enter Book's Author Name");
	String authorName=sc.next();
	books.add(new Book(id,title,authorName));
}
// method to remove a person from system;
public boolean removePerson(int id){
	
	if(persons.remove(new Person(id,"",0)))
	return true;
	return false;
}
//method to remove book from system
public boolean removeBook(int bookId){
	for(Book b:books){
		if(b.getBookId()==bookId){
		book=b;	
		}
	}
	if(book.getPerson()==null){
	if(books.remove(new Book(bookId,"","")))
		return true;
	}
	return false;
}

//method to count available books
public int availableBooks(){
	int count=0;
	for(Book b:books){
		if(b.getPerson()!=null)
			count++;
	}
	return books.size()-count;
}
//method to get available book for that person
public int getAvailableBooksForPerson(int id){
	for(Person p:persons){
		if(p.getId()==id)
			return p.getHaveMaxBook();
	}
	return -1;
}

// method checkout 
public void checkOut(int personId,int bookId){
	person=null;
	book=null;
	for(Person p:persons){
		if(p.getId()==personId){
			person=p;
		}
		
	}
	for(Book b:books){
		if(b.getBookId()==bookId){
		book=b;	
		}
	}
	if(person==null||book==null){
		System.out.println("Invalid Input");
	}
	else if(book.getPerson()!=null){
		System.out.println("You do not have this book");
	}
	else 
	{
		if(person.getHaveMaxBook()>0){
		book.setPerson(person);
		person.setHaveMaxBook(person.getHaveMaxBook()-1);
		}
		else
		{
		System.out.println("You Have Reached To the Limit......of Issiuing book");
		}
	}
}	

//method checkout 
public void checkIn(int personId,int bookId){
	person=null;
	book=null;
	
	for(Person p:persons){
		if(p.getId()==personId){
			person=p;
		}
		
	}
	for(Book b:books){
		if(b.getBookId()==bookId){
		book=b;	
		}
	}
	if(person==null||book==null){
		System.out.println("Invalid Input");
	}
	else{
		if(book.getPerson()==person){
		book.setPerson(null);
		person.setHaveMaxBook(person.getHaveMaxBook()+1);
		}
	}
}

//Show books
public void showAvailableBook(){
	System.out.println("Available Books");
	for(Book b:books)
	{
		if(b.getPerson()==null){
			System.out.println("Book Id="+b.getBookId()+" Book name="+b.getBookTitle());
		}
			
	}
}
//sHOW ALL BOOKS
public void showAllBook(){
	System.out.println("Available Books");
	for(Book b:books)
	{
		
			System.out.println("Book Id="+b.getBookId()+" Book name="+b.getBookTitle());
		
			
	}
}
// sHOW ALL PERSONS
public void showAllPersons(){
	System.out.println("Available Books");
	for(Person p:persons)
	{
		
			System.out.println("Id="+p.getId()+"Name="+p.getName());
		
			
	}
}
}

