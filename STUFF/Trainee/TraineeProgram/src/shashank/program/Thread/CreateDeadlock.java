package shashank.program.Thread;

public class CreateDeadlock {
	 
    String str1 = "Deadlock1";
    String str2 = "Deadlock2";
     
    Thread t1 = new Thread(){
        public void run(){
            while(true){
                synchronized(str1){
                	
                    synchronized(str2){
                        System.out.println(str1 + str2);
                        try {
    						Thread.sleep(20);
    					} catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
                    }
                }
            }
        }
    };
     
    Thread t2 = new Thread(){
        public void run(){
            while(true){
                synchronized(str2){
           
                    synchronized(str1){
                        System.out.println(str2 + str1);
                        try {
    						Thread.sleep(30);
    					} catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
        CreateDeadlock mdl = new CreateDeadlock();
        System.out.println("Main Starts");
        mdl.t1.start();
        mdl.t2.start();
        System.out.println("Main ENDS ");
    }
}