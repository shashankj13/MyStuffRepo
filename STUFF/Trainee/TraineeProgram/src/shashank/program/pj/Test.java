package shashank.program.pj;


import java.util.Scanner;


public class Test {
	static int no;
	public static void menu(MyLibrary my){
		Scanner sc=new Scanner(System.in);
		System.out.println("Press 1. Add a Person");
		System.out.println("Press 2. Add a Book");
		System.out.println("Press 3. Remove a Person");
		System.out.println("Press 4. Remove a Book");
		System.out.println("Press 5. Book Issue");
		System.out.println("Press 6. Return the book(s)");
		System.out.println("Press 7. To Get Available books");
		System.out.println("Press 8. Max book a Person can issue");
		System.out.println("Press 9. To exit ");
		no=sc.nextInt();
		switch(no){
		case 1:
			my.addPerson();
			break;
		case 2:
			my.addBook();
			break;
		case 3:
			System.out.println("List of Person......");
			my.showAllPersons();
			System.out.println("Enter Person ID");
			int id=sc.nextInt();
			if(my.removePerson(id))
				System.out.println("Person Deleted");
			else
				System.out.println("Person Not found");
			break;
		case 4:
			System.out.println("List Of all Available Books");
			my.showAvailableBook();
			System.out.println("Enter Book ID");
			int bookid=sc.nextInt();
			if(my.removeBook(bookid))
				System.out.println("Book Deleted");
			else
				System.out.println("Either Book Not found or Issued by someone else");
			break;
		case 5:
			my.showAvailableBook();
			System.out.println("Enter your Id");
			int pId=sc.nextInt();
			System.out.println("Enter Book Id you want To issue");
			int bId=sc.nextInt();
			my.checkOut(pId, bId);
			break;
		case 6:
			System.out.println("Enter your Id");
			pId=sc.nextInt();
			System.out.println("Enter Book Id you want To issue");
			bId=sc.nextInt();
			my.checkIn(pId, bId);
			break;
		case 7:
			System.out.println("No of available Books="+my.availableBooks());
			break;
		case 8:
			System.out.println("Enter Person's Id ");
			id=sc.nextInt();
			System.out.println("No Of books You can Loan="+my.getAvailableBooksForPerson(id));
			break;
		case 9:
			sc.close();
			System.exit(0);
		default:
			System.out.println("Invalid input");
		}
	}
	public static void main(String[] args) {
		MyLibrary myLib=new MyLibrary();
		do{
			menu(myLib);
		}while(true);

	}
}
