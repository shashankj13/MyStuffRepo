import java.util.*;

class Demo{
	public static void main(String args[]){
		Set<Employee> set = new TreeSet();
		set.add(new Employee(1,"A",26));
		set.add(new Employee(2,"B",24));
		set.add(new Employee(4,"C",95));
		set.add(new Employee(3,"D",48));
		System.out.println(set);
	}
}