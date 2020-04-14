import java.util.*;

//_*_ABSTRACT CLASS   having different kind of functions_*_//

abstract class Employee
{
	Employee() {System.out.println("Employee constructor called\n");}				//constructor
	void fun() {System.out.println("I,m fun method of Employee class\n");}				//regular function
	final void fun1() {System.out.println("I'm final method of Employee class, can't overrride  me\n");}	//final fun
	static void fun2() {System.out.println("I'm static method of Employee class\n");}			//static fun
	abstract void salary();								//abstract fun
}

//*_*Permanent Employe having MONTHLY mode of salary*_*//

class PermanentEmployee extends Employee
{
	Scanner noOfMonth = new Scanner(System.in);
	double month;
	double salaryPerMonth = 85470.0;
	void salary()                                                         // implimenting salary in one way
	{
		System.out.println("\t::::::::::Salary calculator for Permanent Employee::::::::::\n");
		System.out.println("\tEnter the number of months salary to be paid to this employee:");
		month = noOfMonth.nextDouble();
		System.out.println();
		System.out.println("\tSalary of  "+month+" months for this employee is INR: "+(month*salaryPerMonth)+"\n");
	}
}

//*_*Permanent Employe having HOURLY mode of salary*_*//

class ContractEmployee extends Employee
{
	Scanner noOfHour = new Scanner(System.in);
	double hour;
	double salaryPerHour =105.52 ;
	void salary()		                   // implimenting salary in second way
	{
		System.out.println("\t::::::::::Salary calculator for Contract Employee::::::::::\n");
		System.out.println("\tEnter the number of hours salary to be paid to this employee:  ");
		hour = noOfHour.nextDouble();
		System.out.println();
		System.out.println("\tSalary of  "+hour+" hours for this employee is INR: "+(hour*salaryPerHour)+"\n");
	}
}

//_*_Class used by Company for main calculations depending on given contrains or type of employes_*_//

class Company
{
	 public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("In main method\n");
		PermanentEmployee empP = new PermanentEmployee();                          //by default constructor call 
		ContractEmployee empC = new ContractEmployee();		// by object of both class
		empP.fun1();						//fun1 called by object of PermanentEmployee
		empC.fun2();						//fun2 called by object of ContractEmployee 
		System.out.println();						

//_*_Main motive stats from here. This loop to continue the process of calculating salary_*_//

		while (true)
		{	
			System.out.print("Do you want to calculate Employees Salary: [1(YES)/0(NO)]    ");
			int flag = in.nextInt();
			System.out.println();
			if (flag == 0)                               //Flag to check continuity of  the loop
			break;
			System.out.println("\t######This is the time for Calculating Salary######");
			System.out.println();
			Scanner ins = new Scanner(System.in);
			System.out.println("\tWhat kind of employee you are dealing now Permanent {P} or Contract {C}? [P/C]     ");
			String emp = ins.nextLine();
			System.out.println();		
			if (emp.equals("P"))
				empP.salary();          //salary method for permanent employee
			else if(emp.equals("C"))
				empC.salary();         //salary method for contract employee
			else
				System.out.println("\tInvalid input\n");
		}
		System.out.println("\t\t\tThanks for using Subu Pvt. Ltd. Software!!!!\n");		
	}
}