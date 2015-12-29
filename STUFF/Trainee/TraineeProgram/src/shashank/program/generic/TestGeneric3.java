package shashank.program.generic;


public class TestGeneric3 {
	public static <E> void  print(E []elements){
		for(E ele : elements){
			System.out.println(ele);
		}
	}



	public static void main(String[] args) {
		
		Character []  charArray= {'a','b','c','d','e'};
		
		Integer [] intArray = {1,2,3,4,5};
		
		System.out.println("CHAR ARRAY");
		print(charArray);
		System.out.println("INT ARRAY");
		print(intArray);
	}

}
