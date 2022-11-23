package assignment;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.lang.System.*;
import java.sql.*;


public class Usermenu {

	public static void userMultiChoice() 
	{
		System.out.println("Hello User. Please choose from the options below ");
		System.out.print("\nA) Withdraw \nB) Deposit \nC) Apply for a loan \nD)Log out \n You have chose: ");

		Scanner scan = new Scanner(System.in);
	    String userChoice = scan.next();
		/* System.out.println(userChoice);*/

		switch(userChoice) {
		 case "A":
		 Withdraw();

		 break;

		 case "B":
		 Deposit();

		 break;

		 case "C":
		 Loan();
		 
		 break;

		 case "D": System.out.println("\nThank you for using Bank Of America. We appreciate your custom.");
		 System.exit(0);

		}
		 

	    System.out.println("\nPress button to go back to main menu or D to exit");
	    Scanner scann = new Scanner(System.in);
	    String userChoice1 = scan.next();
	    
	  }
	    



	      
		private static void Usermenu() {
		// TODO Auto-generated method stub
		
	}





		public static void Withdraw()
{
			try
			{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");
		
		 	
		System.out.println("Please enter the amount you want to withdraw: ");  
		
		int balance = 500;
	
		Scanner stringScanner = new Scanner(System.in);
		int amt = stringScanner.nextInt();
		System.out.println("Please take your money" );
	
		int newBalance = balance - amt;
	    if (500 >= amt) {
	    System.out.println("Balance after withdrawal: " + balance);  
		} 
		else
	    {  
       System.out.println("Your balance is less than " + amt + "Transaction failed" ); 
       System.out.println("Please try again" ); }
	   
	    System.out.println("Please wait while we get your money");
	    System.out.println("Please take your money");
	    System.out.println("Your transaction is complete");
	    System.out.println("\nPress button to go back to main menu or D to exit");
		 Scanner scan2 = new Scanner(System.in);
		 scan2.nextLine();
		 userMultiChoice();
		 
		 con.close();
		
			
			}
		     	       	
		 	
		 catch(Exception e) {
		 	 System.out.println(e);
		 }
	    
		
			
}
			
		
		



public static void Deposit() 
{
			try
{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");

long amt;  
System.out.println("Please enter the amount you want to deposit: "); 

Scanner stringScanner = new Scanner(System.in);
String depositAmt = stringScanner.next();
System.out.println("Thank you for making a deposit of: " + depositAmt );
System.out.println("Please take your reciept");
System.out.println("We appreciate your custom");
System.out.println("Your transaction is complete");

System.out.println("\nPress button to go back to main menu or D to exit");
Scanner scan2 = new Scanner(System.in);
scan2.nextLine();
userMultiChoice();

	con.close();
	    	       	}
		
	catch(Exception e) {
		 System.out.println(e);}
		    	}


		



public static void Loan() 

{
System.out.println("Thank you for choosing to apply for a loan");
System.out.println("Please note that a hard credit check will need to be perfromed");
System.out.println("Are you happy to continue?");
Scanner stringScanner1 = new Scanner(System.in);
String response = stringScanner1.next();

System.out.println("Please enter the amount you will want to take out (omit £ sign): ");
Scanner stringScanner = new Scanner(System.in);
String loanAmount = stringScanner.next();
System.out.println("If accepted your interest rate will be 7% ");
System.out.println("What is the loan for?");
Scanner stringScanner2 = new Scanner(System.in);
String purpose = stringScanner.next();

System.out.println("We need to conduct a hard credit check. Can we go ahead?");
Scanner stringScanner3 = new Scanner(System.in);
String response2 = stringScanner.next();

System.out.print("Unfortunately on this occasion you have been declined due to adverse information on your file.");
System.out.println(" Please check yosur credit file");
System.out.println("Thank you");

System.out.println("\nPress button to go back to main menu or D to exit");
Scanner scan2 = new Scanner(System.in);
scan2.nextLine();
userMultiChoice();

		
		 	    	}
}
	



	     
