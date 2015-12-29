import java.util.*;

class Remove2{
	public static void main(String args[]){
		Scanner k = new Scanner(System.in);
		System.out.println("Enter String ");
		String k1 = k.next();
		
		System.out.println("Enter Char to be removed");
		String k2 = k.next();
		char k3 = k2.charAt(0);
		System.out.print(k1.replace(k3,' '));
	}
}