package shashank.program.extrastuff;

import java.util.Scanner;


class KeyValueArray{
	
	private Scanner k;
	private int s;
	private String s1;
	int arraykey [] = new int [50];	
	String arrayValue [] = new String [50];
	static int i =0;	
	void input(){
		
	
	k = new Scanner(System.in);
	System.out.println("Enter Key");
	s = k.nextInt();
	
	System.out.println("Enter Value");
	s1 = k.next();
	}
	
	void showinput()
	{
		System.out.println("Entered Key is " + s + " and value is " + s1);
		for(int j=0;j<i;j++)
		{	System.out.println(arraykey[j]);
			System.out.println(arrayValue[j]);}
	}
	
	void addKey(){
		arraykey[i] = s;
	}
	void addValue(){
		arrayValue[i] = s1;
		i++;
	}
}

public class MyMap {

	private static Scanner k1;

	public static void main(String[] args) {
		
		String ch;
		
		do{
		
			System.out.println("DO you want to enter");
			k1 = new Scanner(System.in);
			 ch = k1.next();	
			KeyValueArray kva = new KeyValueArray();
			kva.input();
		
			kva.addKey();
			kva.addValue();
			kva.showinput();
		
		}while(ch=="n" || ch=="N");

	}

}
