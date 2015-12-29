package shashank.program.Thread;

public class MyClas extends Thread{
	
	public static void main(String[] args) {
		
		Thread t = new Thread();
		t.run();
		System.out.println("one");
		t.run();
		System.out.println("Two");
		t.start();
	}
	
	public void run(){
		System.out.println("Thread");
	}

}
