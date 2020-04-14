import java.util.*;
import java.time.*;


//____________*********INTERFACE FOR UGC*********____________//

interface  UGC
{
	Scanner p = new Scanner(System.in);
	Random rand = new Random();
	int min = 12000000;
	int max = 12010000;
	int range = max - min +1;
	default int getAdmission()  // default method
	{
		System.out.println("Percentage in Qualiying Exam: ");
		int percentage;
		percentage = p.nextInt();
		int registration_number = 0;
		if (percentage>=60)	
			registration_number = rand.nextInt(range) + min ;
		return registration_number;
	}
	String payFee();            	//abstract method	
}

//____________*********INTERFACE FOR AICTE*********____________//

interface AICTE
{
	Random rand = new Random();
	int min = 200000;
	int max = 201000;
	int range = max -min +1;
	default int getAdmission()
	{
		LocalDate ld=LocalDate.now();
		System.out.println("You can join counselling after 5 days on: "+ld.plusDays(5));
		int token_number;
		token_number = rand.nextInt(range) + min;
		return token_number;
	}
	String payFee();
}

//____________*********CLASS FOR IMPLIMENTING INTERFACE, OVERRINDING getAdmission() METHOD, TAKING ADMISSION & GETTING FEE_DUE AMOUNT*********____________//

class University implements UGC, AICTE
{
	Scanner p = new Scanner(System.in);
	Random rand = new Random();
	int r_item;		     			  //Return_item
	int min_r = 12000000;                  			  // Minimun_Registration_Number
	int max_r = 12010000;	    			 // Maximun_Registration_Number
	int range_r = max_r - min_r +1;
	int min_t = 200000;		    			 // Maximun_token_Number
	int max_t = 201000;		    			 // Maximun_token_Number
	int range_t = max_t -min_t +1;
	static int registration_number;
	static int token_number;
	static int fee_due;	
	static boolean throughUGC = true;				
	public int getAdmission()
	{
		System.out.print("\nEnter the Percentage Scored in Qualifying Exam: ");
		int percentage = p.nextInt(); 
		if ( percentage >= 60 )
		{
			throughUGC = true;
			System.out.println("\n\tCongrtulations!!\tYou are eligible for direct Admission through UGC.");
			System.out.println();
			registration_number = rand.nextInt(range_r) + min_r ;
			r_item = registration_number;
			fee_due = 25000;
		}
		else 
		{
			System.out.println("\n\tSorry!!\tYou are eligible for direct Admission through AICTE.\n");
			throughUGC = false;
			LocalDate ld=LocalDate.now();
			System.out.println("\tYou can join counselling after 5 days, i.e. on: "+ ld.plusDays(5)+"\n");
			token_number = rand.nextInt(range_t) + min_t;
			r_item =  token_number;
			fee_due = 34000;
		}
		return r_item;
	} 
	public String payFee()
	{
		String s = "Does Nothing";
		return s;
	}
}

//____________*********CLASS FOR TAKING ADMISSION AND FEE PAYMENT*********____________//

class LPU extends University
{
	Scanner d = new  Scanner(System.in);
	static int receipt;
	int min = 0000;
	int max = 1000;
	int range = max -min +1;
	float deposit;

//##########__________payFee METHOD__________##########//

	public String payFee()
	{
		System.out.println("\tYour Fee Due Amount Is______:>INR "+University.fee_due);
		System.out.println();
		System.out.print("\tIt's Time to Deposit Fee!!!!,\n\n\tEnter amount here_______:INR ");
		deposit = d.nextFloat();
		System.out.println();
		System.out.println("\tRemaining due fee is________:>INR "+(University.fee_due-deposit));
		System.out.println();
		receipt = rand.nextInt(range) + min;
		String receipt_num = "LPU-"+receipt;
		return receipt_num;
	}
	
//##########__________MAIN METHOD__________##########//

	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("\t\t\t################################################"); 
		System.out.println("\t\t\t__________________________________________________"); 
		System.out.println("\t\t\t   UGC & AICTE DIRECT ADMISSION FORUM FOR LPU"); 
		System.out.println("\t\t\t__________________________________________________"); 
		System.out.println();
		while (true){
		System.out.print("Do you want to take admission: [Y/N]  ");
		String flag = in.nextLine();
		if (flag.equals("N"))
			break;
		System.out.print("\nEnter your First Name:>");
		String name = in.nextLine();
		LPU obj = new LPU();
		int r_item = obj.getAdmission();
		if (University.throughUGC)
			System.out.println("\t"+name+", Your admission procedure is Completed\n\n\tRegistration Number Allotted to you  is:"+r_item);
		
		else
		{
			System.out.println("\t"+name+", Your token number is_____:>"+r_item+"\n\n\tHope you'll get Admission through AICTE");
			System.out.println();
			System.out.println("\tLuckly You got the admission on remaining Seats.");
			System.out.println();
		}
		System.out.println();
		System.out.println("\tReceipt Number____________:>"+obj.payFee());
		System.out.println();	
		System.out.println("\tThanks "+name.toUpperCase()+", for choosing LPU , WE ENSURE YOU FOR YOUR BETTER FUTURE !! #THINK_BIG");
		System.out.println();
		}
		System.out.println("\nThanks for Reaching out to our LOVELY Campus.");
	}

}





