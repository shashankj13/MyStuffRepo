package shashank.program.Strings;

import java.util.*;


class RemoveChar{
	char cs[]=new char[50];
	String smain="";
	void remove(String s , char c){
		
		for(int j =0;j<s.length();j++){
			cs[j]=s.charAt(j);
		}
		System.out.println(cs);
		for(int i=0;i<s.length();i++){
			if(c == s.charAt(i)){
				cs[i]=' ';
			}
			
		}
		
		System.out.println(cs);
		
	}
}

class Remove{
	private static Scanner k;

	public static void main(String args[]){
		k = new Scanner(System.in);
		System.out.println("Enter String ");
		String k1 = k.next();
		
		System.out.println("Enter Char to be removed");
		String k2 = k.next();
		char k3 = k2.charAt(0);
		
		RemoveChar rc = new RemoveChar();
		rc.remove(k1,k3);
		
	}
}