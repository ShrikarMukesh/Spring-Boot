package com.shrikar.springboot;

public class Account {
	
	private int accno;
	private String atype;
	private String bcode;
	private double balance;
	
	public Account() {}
	
	public Account(int accno, String atype, String bcode, double balance) {
		super();
		this.accno = accno;
		this.atype = atype;
		this.bcode = bcode;
		this.balance = balance;
	}
	
	//Setters and Getters
	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return accno + ", " + atype + ", " + bcode + ", " + balance ;
	}
}
