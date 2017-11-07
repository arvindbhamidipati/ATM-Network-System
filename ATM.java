package ATM_Network_System;

/**
 * ATM class that links the bank and the User
 * 
 * @author Arvind Bhamidipati
 * @version 1.0
 */


public class ATM {
	private String associatedBankId;
	private long MAX_WITHDRAW_LIMIT;
	private Bank bank;
	
	/**
	 * Create ATM Instance.
	 * @param associatedBankId
	 * @param bank
	 * @param MAX_WITHDRAW_LIMIT
	 */
	
	public ATM(String associatedBankId, Bank bank, long MAX_WITHDRAW_LIMIT){
		this.associatedBankId = associatedBankId;
		this.bank = bank;
		this.MAX_WITHDRAW_LIMIT = MAX_WITHDRAW_LIMIT;
	}
	
	/**
	 * Prints the limitations set on how much a person can withdraw at a time.
	 */
	
	public void printATMStatus(){
		System.out.println("Status for ATM with Bank ID: " + associatedBankId + " ATM max withdraw limit: " + MAX_WITHDRAW_LIMIT);
		System.out.println();
	}
	
	/**
	 * Get Bank
	 * @return bank
	 */
	
	public Bank getBank(){
		return this.bank;
	}
}
