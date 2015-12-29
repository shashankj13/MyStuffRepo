package shashank.program.generic;

import java.util.Scanner;

interface Football{
	Football ballType();
	
}


class Nike implements Football{
	 @Override
	   public Football ballType() {
	      System.out.println("NIKE FOOTBALL");
		return null;
	}
}

class Adidas implements Football{
	@Override
	   public Football ballType() {
	      System.out.println("Adidas FOOTBALL");
	      return null;
	 }
}

class Reebok implements Football{
	@Override
	   public Football ballType() {
	      System.out.println("Reebok FOOTBALL");	
	      return null;
	}
}


class FootballFactory{
	
	public Football getFootball(char c){
		if(c == 'n' || c=='N'){
			
			return new Nike().ballType();
		}
		if(c == 'a' || c=='A'){
			
			return new Adidas().ballType();
		}
		if(c == 'r' || c=='R'){
			
			return new Reebok().ballType();
		}
		return null;
	}
	
}


public class TestFactory {

	private static Scanner k;

	public static void main(String[] args) {
	
		
		k = new Scanner(System.in);
		System.out.println("Enter Tpye of Football(Nike -  Adidas - Reebok)");
		String string = k.next();
		char c = string.charAt(0);
		
		FootballFactory footballfactory = new FootballFactory();
		footballfactory.getFootball(c);
		
	}

}
