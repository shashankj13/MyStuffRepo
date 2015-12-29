package shashank.program.db.user;


import java.util.List;
import java.util.Scanner;

import shashank.program.db.dao.CustomerDao;
import shashank.program.db.domain.Customer;


public class Presentation {
	
	private static Scanner k;
	
	
	  static Customer customer;
	  static int idCount=1;

	public static void main(String[] args) {
		
		customer = new Customer();
		do{
			int no;
			Scanner sc=new Scanner(System.in);
			System.out.println("1. INSERT INTO TABLE CUSTOMER");
			System.out.println("2. DELETE FROM TABLE CUSTOMER");
			System.out.println("3. UPDATE TABLE CUSTOMER");
			System.out.println("4. GET ALL CUSTOMERS");
			System.out.println("5. GET CUSTOMER BY ID");
			System.out.println("6. TO EXIT ");
			no=sc.nextInt();
			switch(no){
			case 1:
				k=new Scanner(System.in);
				System.out.println("Enter Customer Name");
				String name = k.next();
				System.out.println("Enter Address");
				String address = k.next();
				
				int idMax = CustomerDao.setMaxId();
				customer.setName(name);
				customer.setAddress(address);
				customer.setId(++idMax);
				
		
				CustomerDao.insertIntoCustomer(customer);
				
				
				
				break;
			case 2:
				System.out.println("Enter Id");
				k=new Scanner(System.in);
				int input = k.nextInt();
				CustomerDao.deleteCustomer(input);
				
				
				break;
			case 3:
			
				char ch;
				Scanner stringScanner;
				System.out.println("Enter Your Id");
				k= new Scanner(System.in);
				int inputid = k.nextInt();
				
				stringScanner= new Scanner(System.in);
				System.out.println("a. Change your name");
				System.out.println("b. Change your address");
				stringScanner= new Scanner(System.in);
				String NameAdd = stringScanner.next();
				
				
				
				ch = NameAdd.charAt(0);
				if(ch=='a' || ch=='A'){
					System.out.println("Enter Name");
					stringScanner= new Scanner(System.in);
					String inputNameAdd = stringScanner.next();
					CustomerDao.updateCustomer(inputid,inputNameAdd,1);
				}
					
				if(ch=='b' || ch=='B'){
					System.out.println("Enter Address");
					stringScanner= new Scanner(System.in);
					String inputNameAdd = stringScanner.next();
					CustomerDao.updateCustomer(inputid,inputNameAdd,0);
				}
				List<Customer> list1 = CustomerDao.getAllCustomer(customer);
				for(Customer c1 : list1)
					System.out.println(c1);
			
				
				break;
			case 4:
				List<Customer> list = CustomerDao.getAllCustomer(customer);
				for(Customer c : list)
					System.out.println(c);
				break;
			case 5:
				System.out.println("Enter Id");
				k=new Scanner(System.in);
				int input1 = k.nextInt();
				CustomerDao.getCustomerById(input1);
				
				
				break;
			
			case 6:
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid input");
			}
		}while(true);

	}

	}

