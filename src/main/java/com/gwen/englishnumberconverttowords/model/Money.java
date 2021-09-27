package com.gwen.englishnumberconverttowords.model;

import java.io.Serializable;

public class Money implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String amount;
	private String cents;
	
	/**
	 * 
	 */
	public Money() {
		super();
	}

	/**
	 * @param amount
	 * @param cents
	 * @param currency
	 */
	public Money(String amount, String cents) {
		super();
		this.amount = amount;
		this.cents = cents;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCents() {
		return cents;
	}

	public void setCents(String cents) {
		this.cents = cents;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", cents=" + cents + "]";
	} 
	
}
