class StringRev
{
static int i1;
public static void main(String args[])
{
		String r =  "This STRING has Been Reversed";
		String result[] = new String[500]; 
		for(int i=0;i<r.length();i++){
			result[i]=r.charAt(i);
			
			if(r.charAt(i)==' '){
				
				result [i1]=r;
				i1++;
			}
		}
		String revResult = "";
        for(int i1 = result.length - 1; i1 >= 0 ; i1--)
        {
            revResult= revResult + result[i1] + " ";
        }

		System.out.println(revResult);

}
}