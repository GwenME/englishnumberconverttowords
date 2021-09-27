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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((cents == null) ? 0 : cents.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (cents == null) {
			if (other.cents != null)
				return false;
		} else if (!cents.equals(other.cents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", cents=" + cents + "]";
	} 
	
}
