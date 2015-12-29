package shashank.program.Thread;

public class TestThread {
	
		public static void main(String[] args) {
			final MyStack m=new MyStack();
			new Thread("Sun"){
				public void run(){

					for(int i = 0 ; i <=10 ; i ++){
						synchronized (m) {
							m.pop();
						}
						
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}}
				}
			}.start();
			new Thread("Moon"){
				public void run(){

					for( int j = 0 ; j <=10 ; j ++){
						synchronized (m) {
							m.push(j);
						}
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}}
				}
			}.start();
		}
	}

