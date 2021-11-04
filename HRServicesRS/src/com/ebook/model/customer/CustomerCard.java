package com.ebook.model.customer;

public class CustomerCard {
	
	private String cardNum;
	private String firstName;
	private String lastName;
	private int securityNum;
	private int month;
	

	private int year;
	private int zipCode;
	
	
	public CustomerCard() {}
	
	
	
	@Override
	public String toString() {
		return "CreditCard [cardNum=" + cardNum + ", firstName=" + firstName + ", lastName=" + lastName + ", month="
				+ month + ", securityNum=" + securityNum + ", year=" + year + ", zipCode=" + zipCode + "]";
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSecurityNum() {
		return securityNum;
	}

	public void setSecurityNum(int securityNum) {
		this.securityNum = securityNum;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
