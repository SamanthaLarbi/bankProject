package assignment;
import java.util.Scanner;
import java.sql.*;

public class Mainmenu

{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[]args) 
	
	
	{
		
			
			System.out.println("Welcome To The Bank Of America ");
			System.out.println("We appreciate your custom. ");
			System.out.println("Are you a User or are you an Admin? ");
			
			String UserorAdmin = scan.nextLine();	
	     	if (UserorAdmin.equals("User")){
	     	Usermenu.userMultiChoice();
	     	
	     	}else {
	     		System.out.println("Hello Admin");
				System.out.println("Can you pleae enter your username");
				
				Scanner scan = new Scanner(System.in);
			    String adminChoice = scan.next();
				System.out.println("Can you pleae enter your password");
				System.out.println("Security Passed");
				
	     		Adminmenu.adminMultiChoice();
	     	}
	
	     	
	
	}
}


	

		
