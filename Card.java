package ATM_Network_System;

/**
 * The Card class
 * Creates a card instance with expiration date
 *
 * @author Arvind Bhamidipati
 * @version 1.0
 */

import java.util.Calendar;
import java.util.Date;

public class Card {
	// private String bankName;
	private String cardNumber;
	private int accountNumber;
	private String bank_id;
	private Date expirationDate;

	/**
	 * Card Instance
	 * @param bank_id
	 * @param accountNumber
	 */
	public Card(String bank_id, int accountNumber) {
		this.bank_id = bank_id;
		this.accountNumber = accountNumber;

		this.cardNumber = bank_id + accountNumber;

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 6);

		Date expirationDateTypeDate = cal.getTime();
		this.expirationDate = expirationDateTypeDate;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @return accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @return bank_id
	 */
	public String getBank_ID() {
		return bank_id;
	}

}
