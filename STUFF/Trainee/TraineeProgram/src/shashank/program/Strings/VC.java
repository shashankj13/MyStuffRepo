package shashank.program.Strings;

class VC{
	static int v=0;
		static int c=0;
	public static void main(String...args){
		String input="ABCD EF WQGH";
		
		for(int i=0;i<input.length();i++){
			if(input.charAt(i) == 'A' || input.charAt(i) == 'E' || input.charAt(i) == 'I' || input.charAt(i) == 'O' || input.charAt(i) == 'U' )
					v++;
				else
				c++;
			if(input.charAt(i)==' '){
				c--;
			}
		}
		System.out.println("Vowels : " +v);
		System.out.println("CONSONENT : " +c);
	}
}