package shashank.program.extrastuff;



public class Excp {
 
	static int  d =10;
	public static void main(String[] args) {
		try {
			 d = 10 / 0;
			System.out.println(d);
			
		} 
		
		
		catch(NullPointerException e ){}
		catch (ArithmeticException e) {}
	}

}
