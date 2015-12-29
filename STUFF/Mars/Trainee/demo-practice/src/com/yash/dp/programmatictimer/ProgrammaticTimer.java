package com.yash.dp.programmatictimer;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.TimerService;


@Stateless
@LocalBean
public class ProgrammaticTimer {

	@Resource
	TimerService timerService;
    
    public ProgrammaticTimer() {
        
    }
    
    public void startTimer(){
    	ScheduleExpression scheduleExpression = new ScheduleExpression().hour("*").minute("*").second("*");
    	timerService.createCalendarTimer(scheduleExpression);
    }

    @Timeout
	public void myTimerProg() {
		System.out.println("I AM PROGRAMMATIC TIMER");
	}
    

}
