package shashank.program.ps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyLibrary {

	List <Book>bookList = new ArrayList<Book>();
	List <Person>personList = new ArrayList<Person>();
	//List issueBook = new ArrayList();
	static int personId = 0; 
	 static int bookId = 0; 
	 Set issuedBook = new HashSet();
	 Map bookRecord = new HashMap();
	
	
	

	public void addBook(Book bookName) {
		bookName.setBookId(++bookId);
		bookList.add(bookName);

	}

	public void addPerson(Person person) {
		person.setPersonId(++personId);
		personList.add(person);

	}

	public void displayBook() {
		System.out.println(bookList);

	}

	public void displayPerson() {
		System.out.println(personList);

	}



	public void removeBook(String title) {
		Iterator itr1 = bookList.iterator();

		while (itr1.hasNext()) {

			Book book = (Book) itr1.next();
			String name = book.getTitle();
			if (name.equalsIgnoreCase(title)) {
				itr1.remove();

			}

		}

	}

	public void removePerson(String name1) {

		Iterator itr1 = personList.iterator();

		while (itr1.hasNext()) {

			Person person = (Person) itr1.next();

			String name = person.getName();

			if (name.equalsIgnoreCase(name1)) {
				itr1.remove();

			}

		}

	}

	


	public void checkIn(String personName , String bookName  ){
		
		Iterator<Person> iterator = personList.iterator();
		Iterator <Book>iterator2 = bookList.iterator();
		Person person=new Person();
		Book book= new Book();
		while(iterator.hasNext()){
			Person person2=iterator.next();
			if(person2.getName().equalsIgnoreCase(personName)){
				person=person2;
			}
		}
		
		while(iterator2.hasNext()){
			Book book1=iterator2.next();
			if(book1.getTitle().equalsIgnoreCase(bookName)){
			book=book1;
			}/*else{
				System.out.println("Book not available!");
			}*/
		}
		if(book.available){
		if(personList.contains(person)&&bookList.contains(book)){
			
			issuedBook.add(book.getBookId());
			bookRecord.put(book.getBookId(), person.getName());
			book.setAvailable(false);
			book.setPerson_name(person.getName());
			System.out.println("Book alloted!");
		}
		else {
			System.out.println("Book not available");
		}}
		else{
			System.out.println("already issue");
		}
	
		
		
		
	}
	
	
	
	public void displayBookRecord(){
		
		
		System.out.println(bookRecord);
	}
	
	public void checkOut(String personName , int bookId , String bookName){
		
		Iterator<Person> iterator = personList.iterator();
		Iterator <Book>iterator2 = bookList.iterator();
		Person person=new Person();
		Book book= new Book();
		while(iterator.hasNext()){
			Person person2=iterator.next();
			if(person2.getName().equalsIgnoreCase(personName)){
				person=person2;
			}
		}
		
		while(iterator2.hasNext()){
			Book book1=iterator2.next();
			if(book1.getTitle().equalsIgnoreCase(bookName)){
			book=book1;
			}
		}
		
		
		if(!book.available){
			if(personList.contains(person)&&bookList.contains(book)){
				issuedBook.remove(book.getBookId());
				bookRecord.remove(book.getBookId());
				System.out.println("Book Return");
				
				
			}
		}else{
			
			System.out.println("book is not from our library");
			
		}
		
		
	}
	
}