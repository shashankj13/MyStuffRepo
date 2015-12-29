package shashank.program.extrastuff;

class InvalidAgeException extends Exception{  
   

	private static final long serialVersionUID = 1L;

	InvalidAgeException(String s){  
    // super(s);  
    }  
   }  

public class TestCustomException1{  
    
    static void validate(int age)throws InvalidAgeException{  
      if(age<18)  
       throw new InvalidAgeException("not valid");  
      else  
       System.out.println("welcome to vote");  
    }  
      
    public static void main(String args[]){  
       try{  
       validate(13);  
       }catch(Exception m){System.out.println("Exception occured: "+m);}  
   
       System.out.println("rest of the code...");  
   }  
 }  