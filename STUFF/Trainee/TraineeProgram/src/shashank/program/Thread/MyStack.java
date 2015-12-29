package shashank.program.Thread;


class MyStack{
 
                private Object[] data;
                private int top;
                private int MAX_SIZE;
               
                public MyStack()
                {
                                MAX_SIZE=10;
                                data = new Object[MAX_SIZE];
                                top=-1;
                }
               
                public MyStack(int size)
                {
                                MAX_SIZE=size;
                                data = new Object[MAX_SIZE];
                                top=-1;
                }
                public void push(Object obj)
                {
                                if(!isFull())
                                {
                                                data[++top] = obj;
                                                System.out.println("Pushed..... "+obj);
                                }
                                else
                                {
                                                System.out.println("\tSTACK IS FULL !!");
                                }
                               
                }
               
                public Object pop()
                {
                                Object obj=null;
                               
                                if(!isEmpty())
                                {
                                                obj = data[top--];
                                                System.out.println("Popped:......."+obj);
                                }
                                else
                                {
                                                System.out.println("STACK IS EMPTY !!");
                                }                             
                                return obj;
                }
               
                public boolean isFull()
                { return ( top == (MAX_SIZE-1) );}
                               
               
                public boolean isEmpty()
                { return top == -1 ;}
}
