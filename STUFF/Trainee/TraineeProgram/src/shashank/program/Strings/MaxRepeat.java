package shashank.program.Strings;

class Call{
	int maxIndex=count[0];
	int index=0;
	for(int i=1;i<count.length;i++)
		if(count[i]>maxIndex){
			maxIndex=count[i];
			index=i;
		}	
	return index;	

class MaxRepeat{
	public static void main(String...args){
		
		System.out.println(Call.findMaxChar("BCDAA"));
		
	}
}