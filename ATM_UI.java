package ATM_Network_System;

/**
 * The ATM_UI program Main
 * 
 * @author Arvind Bhamidipati
 * @version 1.0
 */


import java.util.Scanner;

public class ATM_UI {
	private static Bank bankA;
	private static Bank bankB;
	
	private static ATM bankA_atm;
	private static ATM bankB_atm;
	
	private static Account userAccount = null;
	private static boolean userValidated;

	public static void main(String[] args) {

		// create the two banks
		bankA = new Bank("A");
		bankB = new Bank("B");

		// create some dummy accounts
		Account testAccount1 = new Account(123, "pass123", new Card("A", 123), 50.00);
		Account testAccount2 = new Account(456, "pass456", new Card("A", 456), 100.00);
		Account testAccount3 = new Account(789, "pass789", new Card("B", 789), 900.00);
		Account testAccount4 = new Account(111, "pass111", new Card("B", 111), 300.00);

		// add them to the banks
		bankA.addAccount(testAccount1);
		bankA.addAccount(testAccount2);
		bankB.addAccount(testAccount3);
		bankB.addAccount(testAccount4);
		
		bankA_atm = bankA.getATM();
		bankB_atm = bankB.getATM();

		//print out state of banks
		bankA.printBankState();
		bankB.printBankState();
		
		//print out states of ATM
		bankA_atm.printATMStatus();
		bankB_atm.printATMStatus();

		userValidated = false;

		// start input for program
		getUserInput();
	}

	private static void getUserInput() {
		Scanner in = new Scanner(System.in);
		if (!userValidated) {
			System.out.println("Welcome to the ATM Program");
			System.out.println("Please enter card number");
			String cardNumber = in.nextLine();
			System.out.println("Please enter password");
			String accountPassword = in.nextLine();
			if (bankA_atm.getBank().verifyPassword(cardNumber, accountPassword) != null) {
				userAccount = bankA_atm.getBank().verifyPassword(cardNumber, accountPassword);
				userValidated = true;
			} else if (bankB_atm.getBank().verifyPassword(cardNumber, accountPassword) != null) {
				userAccount = bankB_atm.getBank().verifyPassword(cardNumber, accountPassword);
				userValidated = true;
			} else {
				System.out.println("account does not exist please reset password or try again");
				in.close();
				return;
			}
		}

		System.out.println("What would you like to do with your account?");
		System.out.println("Options: View Balance, Withdraw");
		String selectedOption = in.nextLine();
		if (selectedOption.equals("View Balance")) {
			System.out.println("Account balance: " + userAccount.returnCurrentBalance());
		}
		if (selectedOption.equals("Withdraw")) {
			System.out.println("Enter the amount you would like to withdraw:");
			double withdrawAmount = Double.parseDouble(in.nextLine());
			userAccount.withdraw(withdrawAmount);
			System.out.println("Account balance: " + userAccount.returnCurrentBalance());
		}
		getUserInput();
		in.close();
	}

}
