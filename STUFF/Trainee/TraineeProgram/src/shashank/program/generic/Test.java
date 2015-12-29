package shashank.program.generic;


import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String...args) {
	    List<String> list = new ArrayList<String>();  
	    list.add("hello");  
	    String s = list.get(0);  
	    //list.add(32);//Compile Time Error  
	    System.out.println(s);
	}

}
