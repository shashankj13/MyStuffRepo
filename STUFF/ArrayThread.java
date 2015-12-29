package shashank.program.Thread;

import java.util.Scanner;

public class ArrayThread {
	
	int size=0;
	private Scanner  k1;
	static int count = -1;
	private Scanner k;
	private int arr[];
	
	
	void input(){
	System.out.println("Enter elements");
	k = new Scanner(System.in);
	size= k.nextInt();
	
	arr = new int[size];
	
	}
	public void Pop(){
		if(isEmpty())
			System.out.println("Stack Empty");
		else
			count--;
	}
	
	public void Push(){
		if(isFull())
			System.out.println("Stack Full");
		else
		
			System.out.println("Enter Value");
			k1 = new Scanner(System.in);
			arr[count]=k1.nextInt();
			count++;
		
	}
	public boolean isEmpty(){
		if(count==-1)
			return true;
			return false;
	}
	public boolean isFull(){
		if(count==size)
			return true;
			return false;
	}

}
