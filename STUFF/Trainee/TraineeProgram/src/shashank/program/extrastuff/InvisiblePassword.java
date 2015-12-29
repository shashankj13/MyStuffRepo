package shashank.program.extrastuff;

import java.io.Console;
import java.util.Scanner;
 class InvisiblePassword {



public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    System.out.println("Please enter your password: ");
    String enteredPassword = input.nextLine();
    Checker tc = new Checker(enteredPassword);
    tc.checkSecurity();
}
}