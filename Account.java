package ATM_Network_System;

/**
 * An Account class that stores account details
 * 
 * @author Arvind Bhamidipati
 * @version 1.0
 */

public class Account {
	private int accountNumber;
	private Card cashCard;
	private String accountPassword;
	private double accountBalance;
	
	/**
	 * Account Instance
	 * @param accountNumber
	 * @param accountPassword
	 * @param cashCard
	 */
	
	public Account(int accountNumber, String accountPassword, Card cashCard) {
		this.cashCard = cashCard;
		this.accountPassword = accountPassword;
		this.accountNumber = accountNumber;
		accountBalance = 0;
	}
	
	/**
	 * Account Method to create object.
	 * @param accountNumber
	 * @param accountPassword
	 * @param cashCard
	 * @param presetAccountBalance
	 */
	
	public Account(int accountNumber, String accountPassword, Card cashCard, double presetAccountBalance) {
		this(accountNumber, accountPassword,cashCard);
		this.accountBalance = presetAccountBalance;
	}
	/**
	 * Withdraw money from account.
	 * @param amountToWithdraw
	 */
	
	public void withdraw(double amountToWithdraw) {
		this.accountBalance = accountBalance - amountToWithdraw;
	}
	
	/**
	 * Get current balance in account.
	 * @return accountBalance
	 */
	
	public double returnCurrentBalance() {
		return accountBalance;
	}
	
	/**
	 * Get Account Number.
	 * @return accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Get Cash Card number
	 * @return caschCard
	 */
	public Card getCashCard() {
		return cashCard;
	}
	
	/**
	 * Get Account Password for respective account.
	 * @return accountPassword
	 */
	public String getAccountPassword() {
		return accountPassword;
	}
}
