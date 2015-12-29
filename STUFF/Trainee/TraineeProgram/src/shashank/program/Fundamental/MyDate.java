package shashank.program.Fundamental;

public class MyDate{
	
	private int day = 1;
	private int month = 1;
	private int year = 2000;
	
	public MyDate(int day ,int month , int year){
		
		this.day=day;
		this.month=month;
		this.year=year;
	}
	
	public MyDate(MyDate date){
		this.day=date.day;
		this.month=date.month;
		this.year=date.year;
	}
	
	public MyDate addDays(int moreDays){
		this.day=day+moreDays;
		return this;	// ??
		
	}
	
	public String toString(){
	String date=day+"-"+month+"-"+year; 
		return date; 
	
	}
}