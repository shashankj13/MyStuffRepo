class SortById implements Comparator{
	
	public int compare(Object obj1 , Object obj2){
		Employee emp1 = (Employee) obj1;
		Employee emp2 = (Employee) obj2;
		
		if(emp1.id==emp2.id){
			return 0;
		}
		
		if(emp1.id > emp2.id){
			return -1;
		}
		
		return 1;
	}
	}
}