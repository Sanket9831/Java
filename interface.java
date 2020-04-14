import java.time.*;

interface Lockdown
{
	int x =21;
	LocalDate ldt = LocalDate.of(2020,Month.MAY, 3);
	default void state() {System.out.println("We all are by 'default'  QUARANTINED!!\n");}
	void place();
	
}
class Home implements Lockdown
{
	public void place() {System.out.println("\nI am SANKET, fortunately at my HOME, State-BIHAR\n");}	
}
class Hostel implements Lockdown
{
	public void place() {System.out.println("My friend ADITYA is inside LPU campus, Hostel-BH6\n");}
}

class Quarantine
{

 	public static void main(String [] args)
	{
		Home hm = new Home();
		Hostel ht = new Hostel();
		hm.place();
		ht.place();
		System.out.println("Earlier, We were locked down for : "+ Lockdown.x+" days\n");
		System.out.println("Now, We are Lockdown till : "+ Lockdown.ldt+"\n");
		hm.state();
	}
}