package assignment;
import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.lang.System.*;
import java.sql.*;

public class Adminmenu {



			public static void adminMultiChoice()
			{
			Scanner scan1 = new Scanner(System.in);
		    String adminChoice1 = scan1.nextLine();
	
			System.out.println("Please choose an option from below");
			System.out.println("\nA) Add customer details \nB) View customers \nC) Add accounts \nD) View accounts \nE) Add branch \nF) View branch \nG) View loans \nH) View transaction details  \nYou have chosen: ");
		
		 Scanner scan11 = new Scanner(System.in);
		 String AdminChoice = scan11.nextLine();
		 System.out.println("You have chosen " + AdminChoice);
	
		 switch(AdminChoice) { 
				
		 case "A":
		 AddCustomer();

		 break;

		 case "B":
	     Viewcustomers();

		 break;

		 case "C":
		 AddAccounts();

		 break;
		 
		 case "D":
		 ViewAccounts();

		 break;
			 
		 case "E":
	     AddBranch();

		 break;
			 
		 case "F":
		 ViewBranch();

		 break;
			 
		 case "G":
	     ViewLoans();

		 break;

		 case "H":
	     ViewTransactions();
	     
	     break;
	     
		 case "I": System.out.println("\nThank you for using Bank Of America. We appreciate your custom.");
		 System.exit(0);
		 }
		 
		 System.out.println("\nPress button to go back to main menu or I to exit");
		    Scanner scann = new Scanner(System.in);
		    String AdminChoice1 = scan1.next();
     		}
		
		
     		
       	







public static void AddCustomer()

{
	try
	{

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");
Scanner scan = new Scanner(System.in);

	PreparedStatement stm = con.prepareStatement(" INSERT INTO customer  VALUES(?,?,?,?,?,?,?,?);");
	Scanner input = new Scanner(System.in);
	
	System.out.println("Please enter customer's ID (e.g.C00013): ");
	String custid = scan.nextLine();
	
	System.out.println("Please enter customer's first name: ");
	String fname = scan.nextLine();
	
	System.out.println("Please enter customer's last name: ");
	String mname = scan.nextLine();
	
	System.out.println("Please enter customer's middle name: ");
	String ltname = scan.nextLine();
	
	System.out.println("Please enter customer's city: ");
	String city = scan.nextLine(); 
	
	System.out.println("Please enter customer's number: ");
	String mobileno = scan.nextLine();
	
	System.out.println("Please enter customer's role: ");
	String occupation = scan.nextLine();
	
	System.out.println("Please enter customer's date of birth (e.g. yyyy-mm-dd): ");
	String dob = scan.nextLine();
	
	stm.setString(1, custid );
	stm.setString(2, fname );
	stm.setString(3, mname );
	stm.setString(4, ltname );
	stm.setString(5, city );
	stm.setString(6, mobileno );
	stm.setString(7, occupation );
	stm.setString(8, dob);
	stm.executeUpdate();
	
	System.out.println("Customer has been added. Thank you");
	System.out.println("\nPress button to go back to main menu or I to exit");

Scanner scann = new Scanner(System.in);
scan.nextLine();
adminMultiChoice();

con.close();
    	       	}
	
catch(Exception e) {
	 System.out.println(e);}
	    	}

		 

public static void Viewcustomers() {
	try
	{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");

System.out.println("We are loading the Customer's details");  

	 Statement stmt = con.createStatement();
	String query = "SELECT custid, fname, mname, ltname, city, mobileno, occupation, dob FROM customer";
    ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
      String custid = rs.getString("custid");
      String fname = rs.getString("fname");
      String mname = rs.getString("mname");
      String ltname = rs.getString("ltname");
      String city = rs.getString("city");
      String mobileno = rs.getString("mobileno");
      String occupation = rs.getString("occupation");
      String dob = rs.getString("dob");
      System.out.println(custid + ", " + fname + ", " + mname +
              ", " + ltname + ", " + city + ", " + mobileno + ", " + occupation + ", " + dob);
     
    }
    System.out.println("\nPress button to go back to main menu or I to exit");
    Scanner scann = new Scanner(System.in);
    scann.nextLine();
    adminMultiChoice();
    
    con.close();
   	}

catch(Exception e) {
System.out.println(e);}
}

	
  
       


public static void AddAccounts() {
	try
	{

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");
Scanner scan = new Scanner(System.in);

	PreparedStatement stm = con.prepareStatement(" INSERT INTO account  VALUES(?,?,?,?,?,?,?);");
	
	Scanner input = new Scanner(System.in); 
	System.out.println("Please enter account number (e.g.A00013): ");
	String acnumber = scan.nextLine();
    
	System.out.println("Please enter account customer ID (e.g.C00005): ");
	String custid = scan.nextLine();
	
	System.out.println("Please enter account branch ID (e.g.B00006): ");
	String bid = scan.nextLine();
	
	System.out.println("Please enter opening balance: ");
	int opening_balance = scan.nextInt();
    
	System.out.println("Please enter account opening date (e.g.yyyy-mm-dd): ");
    int aod = scan.nextInt();
    
	System.out.println("Please enter account type: ");
	String atype = scan.nextLine();
	
	System.out.println("Please enter account status: ");
	String astatus = scan.nextLine();
	
	stm.setString(1, acnumber );
	stm.setString(2, custid );
	stm.setString(3, bid );
	stm.setInt(4, opening_balance );
	stm.setInt(5, aod );
	stm.setString(6, atype );
	stm.setString(7, astatus );
	stm.executeUpdate();
	

	System.out.println("Thank you, the account has now been added");
    System.out.println("\nPress button to go back to main menu or I to exit");
	scan.nextLine();
    adminMultiChoice();
    
con.close();
	}
catch(Exception e) {
	 System.out.println(e);
}
}





public static void ViewAccounts()
{
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");
	
	System.out.println("We are loading the account details");  

	Statement stmt = con.createStatement(); 
	String query = "SELECT acnumber, custid, bid, opening_balance, aod, atype, astatus FROM account";
	ResultSet rs = stmt.executeQuery(query);
    while (rs.next()) {
	      String acnumber = rs.getString("acnumber");
	      String custid = rs.getString("custid");
	      String bid = rs.getString("bid");
	      int opening_balance = rs.getInt("opening_balance");
	      String aod = rs.getString("aod");
	      String atype = rs.getString("atype");
	      String astatus = rs.getString("astatus");
	      System.out.println(acnumber + ", " + custid + ", " + bid +
	              ", " + opening_balance + ", " + aod  + ", " + atype + ", " + astatus);
	   

		
	    }
   
	    System.out.println("\nPress button to go back to main menu or I to exit");
	    Scanner scan = new Scanner(System.in);
	    scan.nextLine();
	    adminMultiChoice();
	    
	    con.close();
	    	}
	    catch(Exception e) {
	    	 System.out.println(e);
	    }
	}
	
	    
	    

   
	
	
	


public static void AddBranch() 
{

try {

Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");
{
	PreparedStatement stm = con.prepareStatement(" INSERT INTO branch  VALUES(?,?,?);");
	Scanner input2 = new Scanner(System.in);
	System.out.println("Thank you for choosing this option");
	System.out.println("Please enter branch ID (e.g.B00012): ");
	String bid = input2.nextLine();
	System.out.println("Please enter branch's name: ");
	String bname = input2.nextLine();
	System.out.println("Please enter branch's city: ");
	String bcity = input2.nextLine();
	
	stm.setString(1, bid );
	stm.setString(2, bname );
	stm.setString(3, bcity);
	stm.executeUpdate();
	
	
	System.out.println("Thank you. The branch has been added.");	
}

System.out.println("\nPress button to go back to main menu or I to exit");
	    Scanner scan = new Scanner(System.in);
	    scan.nextLine();
	    adminMultiChoice();
	    
	    con.close();
	    	}
	    catch(Exception e) {
	    	 System.out.println(e);
	    }
	
	    }
	



	

public static void ViewBranch() {
	try
	{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");
    {
    
    
    	System.out.println("We are loading the branch details"); 
    	System.out.println("Please find the branch details below: "); 
    	

    	Statement stmt = con.createStatement(); 
    	String query = ("select bid, bname, bcity from branch");
    	
    	
    	    ResultSet rs = stmt.executeQuery(query);
    	    while (rs.next()) {
    	      String bid = rs.getString("bid");
    	      String bname = rs.getString("bname");
    	      String bcity = rs.getString("bcity");
    	      System.out.println(bid + ", " + bname + ", " + bcity);

    	    }
    	    System.out.println("Branch details added. ");
    	    System.out.println("\nPress button to go back to main menu or I to exit");
    	    Scanner scan = new Scanner(System.in);
    	    scan.nextLine();
    	    adminMultiChoice();
    	    }
    	    con.close();
    	        	       	}
    	    catch(Exception e) {
    	    	 System.out.println(e);
    	    }
    	        	}

	
public static void ViewLoans() {
	
	try {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");

    	System.out.println("We are loading the loan details"); 
    	System.out.println("Please find the loan details below: "); 
    	
    		
    	Statement stmt = con.createStatement();
    	String query = "SELECT custid, bid, loan_amount FROM loan";
    	    ResultSet rs = stmt.executeQuery(query);
    	    while (rs.next()) {
    	      String custid = rs.getString("custid");
    	      String bid = rs.getString("bid");
    	      int loan_amount = rs.getInt("loan_amount");
    	      System.out.println(custid + ", " + bid + ", " + loan_amount);

    	    }

System.out.println("\nPress button to go back to main menu or I to exit");
Scanner scan = new Scanner(System.in);
scan.nextLine();
adminMultiChoice();

con.close();
    	       	}
catch(Exception e) {
	 System.out.println(e);
}
    	}





   

public static void ViewTransactions(){
	try
	{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Avb1892!");

    	System.out.println("We are loading the transaction details");  
    	String query = "SELECT tnumber, acnumber, dot, medium_of_transaction, transaction_type, transaction_amount FROM trandetails ";
    	
    		Statement stmt = con.createStatement(); 
    	    ResultSet rs = stmt.executeQuery(query);
    	    while (rs.next()) {
    	      String tnumber = rs.getString("tnumber");
    	      String acnumber = rs.getString("acnumber");
    	      String dot = rs.getString("dot");
    	      String medium_of_transaction = rs.getString("medium_of_transaction");
    	      String transaction_type = rs.getString("transaction_type");
    	      int transaction_amount = rs.getInt("transaction_amount");
    	    
    	     
    	      System.out.println(tnumber + ", " + acnumber + ", " + dot +
    	              ", " + medium_of_transaction + ", " + transaction_type + ", " + transaction_amount);
    	      System.out.println("Here are your transactions");
    	      System.out.println("\nPress button to go back to main menu or I to exit");
    	      Scanner scan = new Scanner(System.in);
    	      scan.nextLine();
    	      adminMultiChoice();
    	    } 	       	      
con.close();
    	   
    	    }
	catch(Exception e) {

	 System.out.println(e);
}
    
    } 

	
}
	


	
	
	

		 
	


