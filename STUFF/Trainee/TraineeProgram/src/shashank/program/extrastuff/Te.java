package shashank.program.extrastuff;



class Parent{  
	  void msg() throws Exception{System.out.println("parent");}  
	}  
	  
	class Te extends Parent{  
	  void msg()throws Exception{  
	    System.out.println("child");  
	  }  
	  public static void main(String args[]) throws Exception{  
	   Te p=new Te();  
	   p.msg();  
	  }  
	}  
	
	
