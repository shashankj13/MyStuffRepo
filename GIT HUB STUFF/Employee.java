class Employee implements Comparable{
	private int id;
	private String name;
	private int age;
	
	Employee(int id,String name,int age){
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	public String toString(){
		return name + age ;
	}
	
	public int compareTo(Object obj1){
		Employee emp1 = (Employee) obj1;
		
		if(this.id==emp1.id){
			return 0;
		}
		
		if(this.id > emp1.id){
			return -1;
		}
		
		
		return 1;
	}
	
}





