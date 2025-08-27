// Java Program to Display the ATM Transaction 
import java.io.*; 
//import java.util.Scanner;
public class Atm { 

	// Display current balance in account 
	public static void displayBalance(int balance) 
	{ 
		System.out.println("Current Balance : " + balance); 
		System.out.println(); 
	} 

	// Withdraw amount and update the balance 
	public static int amountWithdrawing(int balance, int withdrawAmount) 
	{ 
		System.out.println("Withdrawn Operation:"); 
		System.out.println("Withdrawing Amount : "+ withdrawAmount); 
		if (balance >= withdrawAmount) { 
			balance = balance - withdrawAmount; 
			System.out.println("Please collect your money and collect the card"); 
			displayBalance(balance); 
		} 
		else { 
			System.out.println("Sorry! Insufficient Funds"); 
			System.out.println(); 
		} 
		return balance; 
	} 

	// Deposit amount and update the balance 
	public static int amountDepositing(int balance, int depositAmount) 
	{ 
		System.out.println("Deposit Operation:"); 
		System.out.println("Depositing Amount : "+ depositAmount); 
		balance = balance + depositAmount; 
		System.out.println("Your Money has been successfully deposited"); 
		displayBalance(balance); 
		return balance; 
	} 

	public static void main(String args[]) 
	{ 
        //BufferedReader bfn = new BufferedReader( new InputStreamReader(System.in));
        //Scanner myObj = new Scanner(System.in); 
		int balance = 50000; 
		int withdrawAmount = Integer.parseInt(args[0]); 
		int depositAmount = Integer.parseInt(args[1]); 
        Atm a = new Atm();
        a.displayBalance(balance);
        a.amountDepositing(balance, depositAmount);
        a.amountWithdrawing(balance, withdrawAmount);

		// calling display balance 
		//displayBalance(balance); 
		// withdrawing amount 
		//balance = amountWithdrawing(balance, withdrawAmount); 
		// depositing amount 
		//balance = amountDepositing(balance, depositAmount); 
	} 
}
