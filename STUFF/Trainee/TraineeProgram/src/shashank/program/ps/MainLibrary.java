package shashank.program.ps;

import java.util.Scanner;

public class MainLibrary {

	private static Scanner sc;
	

	public static void main(String[] args) {
		MyLibrary myLibrary = new MyLibrary();
		sc = new Scanner(System.in);
		String name;
		do {
			System.out.println(" 1. Add Person Details");
			System.out.println(" 2. Add Book Details");
			System.out.println(" 3. Display Person Details");
			System.out.println(" 4. Display Book Details");
			System.out.println(" 5. Remove Book Details");
			System.out.println(" 6. Remove Person Details");
			System.out.println(" 7. Issue Book");
			System.out.println(" 8. Return Book");
			System.out.println(" 9. Display Issue Book");
			System.out.println(" 10. Exit");
			
			int select = sc.nextInt();
			switch (select) {

			case 1:
				Person person = new Person();
				System.out.println("Enter Person Name");
				name = sc.next();
				person.setName(name);
				myLibrary.addPerson(person);
				break;

			case 2:

				Book book = new Book();
				System.out.println("Enter Book Title Name");
				String title = sc.next();
				book.setTitle(title);
				System.out.println("Enter Author Name");
				String author = sc.next();
				book.setAuthor(author);
				/*System.out.println("Enter person  Name who borrow the book");
				String name2 = sc.next();
				book.setPerson_name(name2);*/
				myLibrary.addBook(book);
				break;
			case 3:
				myLibrary.displayPerson();
				break;

			case 4:
				myLibrary.displayBook();
				break;

			case 5:
				System.out.println("Enter book name for delete");
				String title1 = sc.next();
				myLibrary.removeBook(title1);
				break;

			case 6:
				System.out.println("Enter person name for delete");
				String name1 = sc.next();
				myLibrary.removePerson(name1);
				break;
				
			case 7:
				System.out.println("Enter Book name for borrow");
				String bookName = sc.next();
				System.out.println("Enter Your name ");
				String personName = sc.next();
				myLibrary.checkIn(personName, bookName);
				break;
			case 8:
				Book book1 = new Book();
				myLibrary.displayBookRecord();
				System.out.println("Enter book Name for Return");
				String bookName1 = sc.next();
				System.out.println("enter person name");
				String personName1 = sc.next();
				System.out.println("Enter book id");
				int bookId = sc.nextInt();
				book1.setBookId(bookId);
				myLibrary.checkOut(personName1, bookId, bookName1);
				
			case 9:
				myLibrary.displayBookRecord();
				break;
			case 10:
				System.exit(0);
			default:
				System.out.println("Please enter a correct value");

			}
			/*System.out.println("For more Entries Enter Yes");
			choice = sc.next();*/
		} while (true);
	}

}
