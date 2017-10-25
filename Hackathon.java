import java.io.*;
import java.util.*;
abstract class Attendees
{
	String name,college,dept;
	long roll;
	int year;
	static int count=0;
	public Attendees()
	{
		//count++;
	}
	public Attendees(String n,String c,String d,long r,int y)
	{
		name=n;
		college=c;
		dept=d;
		roll=r;
		year=y;
		count++;
	}
	abstract void display();
}
class Workshop extends Attendees
{
	String w_name;
	static int w_count=0;
	boolean fee_payment,attendence;
	public Workshop()
	{
		super();
		fee_payment=false;
		attendence=false;
		//w_count++;
	}
	public Workshop(String n,String c,String d,long r,int y,String w)
	{
		super();
		w_name=w;
		fee_payment=false;
		attendence=false;
		w_count++;
	}
	public void payFees()
	{
		System.out.println("Paying Fees...");
		fee_payment=true;
		System.out.println("Fee Paid:)");
	}
	public void attend()
	{
		if(fee_payment){
			System.out.println("Attending the workshop");
			attendence=true;}
		else
		{
			System.out.println("Fee not paid,Cannot attend the workshop");
			attendence =false;
		}
	}
	public void display()
	{
		System.out.println("Name : " + name);
		System.out.println("College : " + college);
		System.out.println("Department : " + dept);
		System.out.println("Roll number : " + roll);
		System.out.println("Year of study : " + year);
		System.out.println("Workshop attending : " + w_name);
		System.out.print("Fees paid : ");
		if(fee_payment)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.print("Whether attended the workshop : ");
		if(attendence)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	public void getdata(){
		System.out.println("Enter your name , college , department , roll number , year of study and workshop attending");
		Scanner inp = new Scanner(System.in);
		name = inp.next();
		college = inp.next();
		dept = inp.next();
		roll = inp.nextInt();
		year = inp.nextInt();
		w_name = inp.next();
		w_count++;
	}
}
class Event extends Attendees
{
	boolean prizes;
	int no_prizes;
	static int e_count = 0;
	public Event(){
		super();
		prizes = false;
		no_prizes = 0;
		//e_count++;
	}
	public Event(String n,String c,String d,long r,int y){
		super();
		prizes = false;
		no_prizes = 0;
		e_count++;
	}
	public void display(){
		System.out.println("Name : " + name);
		System.out.println("College : " + college);
		System.out.println("Department : " + dept);
		System.out.println("Roll number : " + roll);
		System.out.println("Year of study : " + year);
		System.out.println("No. of prizes won : " + no_prizes);
	}
	public void win(){
		prizes = true;
		no_prizes++;
	}
	public void getdata(){
		System.out.println("Enter your name , college , department , roll number , year of study");
		Scanner inp = new Scanner(System.in);
		name = inp.next();
		college = inp.next();
		dept = inp.next();
		roll = inp.nextInt();
		year = inp.nextInt();
		e_count++;
	}
}
public class Hackathon extends Event{
	static int h_count = 0;
	static String first,second,third;
	public Hackathon(){
		super();
		h_count++;
	}
	public Hackathon(String n,String c,String d,long r,int y){
		super();
		h_count++;
	}
	public void setdata(String f,String s,String t){
		first = f;
		second = s;
		third = t;
	}
	public void display(){
		System.out.println("First prize : " + first);
		System.out.println("Second prize : " + second);
		System.out.println("Third prize : " + third);
	}
	public void getdata(){
		System.out.println("Enter your name , college , department , roll number , year of study");
                Scanner inp = new Scanner(System.in);
                name = inp.next();
                college = inp.next();
                dept = inp.next();
                roll = inp.nextInt();
                year = inp.nextInt();
	}
}
