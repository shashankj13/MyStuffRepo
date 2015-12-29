package shashank.program.Strings;

class CheckDigit{
public static void main(String...args){
	String regex = "[0-9]+";
	String inputString = "123154"; 
	System.out.println(inputString.matches(regex));
	}
}

