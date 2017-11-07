package ATM_Network_System;

/**
 * The Bank class 
 * 
 * @author Arvind Bhamidipati
 * @version 1.0
 */


import java.util.ArrayList;

public class Bank {

	private String bank_id;
	private ArrayList<Account> accounts;
	private ATM atm;

	/**
	 * Bank Instance.
	 * @param bank_id
	 */
	public Bank(String bank_id) {
		this.atm = new ATM(bank_id, this, 100);
		this.bank_id = bank_id;
		this.accounts = new ArrayList<Account>();
	}

	/**
	 * Adds a new account to the Bank
	 * @param newAccount
	 */
	public void addAccount(Account newAccount) {
		accounts.add(newAccount);
	}

	/**
	 * Check to make sure the passowrd is correct to access Account.
	 * @param cardNumber
	 * @param accountPassword
	 * @return account
	 */
	public Account verifyPassword(String cardNumber, String accountPassword) {
		for (Account account : accounts) {
			if (account.getCashCard().getCardNumber().equals(cardNumber)) {
				if (account.getAccountPassword().equals(accountPassword)) {
					return account;
				}
			}
		}
		return null;
	}
	/**
	 * Bank tells us what accounts are in each bank and how much you have in each account. 
	 */
	public void printBankState() {
		// print out all the accounts
		System.out.println("Bank " + bank_id + " status: ");
		for (Account account : accounts) {
			System.out.println("Account number: " + account.getAccountNumber() + " Account balance: "
					+ account.returnCurrentBalance());
		}
		System.out.println();
	}

	ATM getATM(){
		return atm;
	}
	
	String getBank_ID() {
		return bank_id;
	}
}
