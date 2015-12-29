package com.yash.dp.automatictimer;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MyAutoTimer {

    
    public MyAutoTimer() {
       
    }
    
    @Schedule(hour= "*" , minute ="*", second = "*")
    public void startTimer(){
    	System.out.println("Automatic Timer");
    }

}
