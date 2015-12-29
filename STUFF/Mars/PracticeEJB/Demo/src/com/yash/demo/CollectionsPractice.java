package com.yash.demo;

import java.util.ArrayList;
import java.util.List;

public class CollectionsPractice {
	
	public static void main(String args[]){
		List<String> list = new ArrayList<>();
		list.add("asasas");
		list.add("b");
		list.add("hsadasd");
		list.add("e");
		list.add("z");
		list.add("r");
		
		
		
		list.stream().forEach(e-> System.out.println(e));
		
	}

}
