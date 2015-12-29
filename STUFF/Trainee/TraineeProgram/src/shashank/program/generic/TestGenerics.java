package shashank.program.generic;

import java.util.*; 

abstract class Shape{  
	abstract void draw();  
}  

class Rectangle extends Shape{  
void draw(){
	System.out.println("Rectangle");
	}  
}  

class Circle extends Shape{  
void draw(){
	System.out.println("Circle");
	}  
}  
  
  
class TestGenerics{  
 
	public static void drawShapes(List<?> lists){  
		/*for(Shape s:lists){  
			s.draw();
		}*/
		for(int i = 0 ; i<lists.size();i++){
			((Shape) lists.get(i)).draw();}
			System.out.println(lists);
	}  

	public static void main(String args[]){  
		List<Rectangle> list1=new ArrayList<Rectangle>();  
		list1.add(new Rectangle());  
  
		List<Circle> list2=new ArrayList<Circle>();  
		list2.add(new Circle());  
		list2.add(new Circle());  
  
		drawShapes(list1);  
		drawShapes(list2);  
	}
}