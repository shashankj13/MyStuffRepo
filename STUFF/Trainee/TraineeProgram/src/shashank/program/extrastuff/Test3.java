ackage shashank.program.extrastuff;


class A {
	void m1(){
		System.out.println("m1 A");
	}
	void m2(){
		System.out.println("m2 A");
	}
	void m3(){
		System.out.println("m3 A");
	}
}

class B extends A  {
	void m1(){
		System.out.println("m1 B");
	}
}
	
class C extends B  {
		void m3(){
			System.out.println("m3 C");
		}
}

public class Test3 {

	public static void main(String[] args) {
		
		A a = new C();
		a.m1();
		
		A a1 = new C();
		a1.m3();
		
		C c = new C();
		c.m2();
	}
		

	}

