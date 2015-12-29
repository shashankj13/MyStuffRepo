package shashank.program.Strings;


class CountDuplicate{
	public static void main(String [] args ){
		String input = "STRRINGG";
		
		for(int i = 0 ; i < input.length(); i++){
			
				int count=0;
				
				for(int j = 0; j < input.length(); j++){
					if(input.charAt(i) == input.charAt(j)){
							count++;	
								
					}
					if(count > 1){
						System.out.println(input.charAt(i)+" "+ (count));
					}
				}
					
			
		}

	}
}