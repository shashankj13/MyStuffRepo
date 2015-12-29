package com.org.user;


import java.util.Scanner;

import com.org.dao.CustomerSignupDao;



public class Test {

	public static void main(String[] args) {
		
		do{
			int no;
			Scanner sc=new Scanner(System.in);
			System.out.println("1. SIGNUP");
			System.out.println("2. LOGIN");
			System.out.println("3. EXIT");
			no=sc.nextInt();
			switch(no){
			case 1:
				int idMax =CustomerSignupDao.setMaxId();
				PresentationSignup.signup(idMax);
				break;
			case 2:
				boolean cflag = PresentationLogin.login();
				if(cflag)
				{
					System.out.println("1. CHECK BALANCE");
					System.out.println("2. WITHDRAW AMOUNT");
					System.out.println("3. DEPOSIT AMOUNT");
					System.out.println("4. ADD BENIFICIARY");
					System.out.println("5. TRANSFER AMOUNT");
					System.out.println("6. TO EXIT ");
					int check =sc.nextInt();
					while(check!=6){
						
						switch(check){
						case 1:
							PresentationAccount.checkBalance();
							break;
						case 2:
							PresentationAccount.withdrawl();
							break;
						case 3:
							PresentationAccount.deposit();
							break;
						case 4:
							PresentationAccount.showAllAccountHolders();
							break;
						case 5:
							PresentationAccount.transferAmount();
							break;
							
						case 6:
							sc.close();
							System.exit(0);
						default:
							System.out.println("Invalid input");
						}
						System.out.println("1. CHECK BALANCE");
						System.out.println("2. WITHDRAW AMOUNT");
						System.out.println("3. DEPOSIT AMOUNT");
						System.out.println("4. ADD BENIFICIARY");
						System.out.println("5. TRANSFER AMOUNT");
						System.out.println("6. TO EXIT ");
						check =sc.nextInt();
						}
					}
			case 3:
				sc.close();
				System.exit(0);
					}
					
			
		}while(true);

	}

}
