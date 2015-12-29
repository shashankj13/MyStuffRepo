package shashank.program.Strings;

import java.util.*;
class Duplicatepj{
	
	public static String removeDuplicate(int[] count,char[] charArray){
		String s="";
		for(int i=0;i<count.length;i++){
			if(count[i]!=-1)
				s=s+charArray[i];
		}
		return s;
	}
	
	public static boolean matchString(String str){
		String reg="[0-9]+";
		return str.matches(reg);
		
	}
	
	
	
	public static String remove(String str,char ch){
		String stri="";
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)!=ch)
				stri=stri+str.charAt(i);
		}
		return stri;
		
	}
	public static int highestOccurredCharacter(int[] count){
		int maxIndex=count[0];
		int index=0;
		for(int i=1;i<count.length;i++)
			if(count[i]>maxIndex){
				maxIndex=count[i];
				index=i;
			}	
		return index;	
	} 
	public static void main(String...args){
		Scanner sc =new Scanner(System.in);
		sc.useDelimiter("\r\n");
		System.out.println("Enter A String");
		String str=sc.next();
		System.out.println("******Check for digits*******");
		System.out.println(matchString(str));
		
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
		
		System.out.println("*********These characters are duplicate*********");
		for(int i=0;i<count.length;i++){
			if(count[i]>1)
				System.out.print(charArray[i]+" ");
		}
		System.out.println();
		int index=highestOccurredCharacter(count);
		System.out.println("****************Highest Occurred Character is: "+charArray[index]);
		
	//	System.out.println("**************No of vowels and consonants**********");
		//CountVowels c=new CountVowels();
		//c.countMethod(str);
	//	System.out.println("******check character*******");
		//CountOccurance c1=new CountOccurance();
		//System.out.println("Enter character to search");
		String ch=sc.next();
		//System.out.println(c1.count(str,ch.charAt(0)));
		System.out.println("******Remove Specified character from string*******");	
		ch=sc.next();
		System.out.println(remove(str,ch.charAt(0)));
		System.out.println("******Remove duplicate character from string*******");	
		String removedup=removeDuplicate(count,charArray);
		System.out.println(removedup);
	}
}