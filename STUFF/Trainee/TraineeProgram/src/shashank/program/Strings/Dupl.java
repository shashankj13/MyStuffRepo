package shashank.program.Strings;

import java.util.Scanner;

	class Dupl {
		private static Scanner sc;

		public static void main(String args[]) {
			
		
	sc = new Scanner(System.in);
	sc.useDelimiter("\r\n");
	System.out.println("Enter A String");
	String str=sc.next();
	
	char[] charArray=str.toCharArray();
	int[] count=new int[charArray.length];
	for(int i=0;i<charArray.length;i++){
		int count1=1;
		for(int j=i+1;j<charArray.length;j++){
			if(count[i]==-1)
				break;
			if(charArray[i]==charArray[j]){
					
					count[i]=++count1;
					count[j]=-1;
			}
			else{
				
				count[i]=count1;
			}
		
			}
		}
	System.out.println("Duplicate Characters Are:");
	for(int i=0;i<count.length;i++){
		if(count[i]>1)
			System.out.print(charArray[i]+" ");
	}
		}
	}


