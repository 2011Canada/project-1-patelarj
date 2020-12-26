package com.arjun.models;

import java.sql.Date;

public class ReimbursementsTest {
	
	private int reimb_ID;
	private double reimbAmount;
	private Date reimbSubmitted;
	private Date reimbResolved;
	private String reimbDescription;
	private String reimbAuthor;
	private String reimbResolver;
	private String reimbStatus;
	private String reimbType;
	
	
	public ReimbursementsTest(int reimb_ID, double reimbAmount, Date reimbSubmitted, Date reimbResolved,
			String reimbDescription, String reimbAuthor, String reimbResolver, String reimbStatus, String reimbType) {
		super();
		this.reimb_ID = reimb_ID;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	
	public ReimbursementsTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReimb_ID() {
		return reimb_ID;
	}

	public void setReimb_ID(int reimb_ID) {
		this.reimb_ID = reimb_ID;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Date getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Date date) {
		this.reimbSubmitted = date;
	}

	public Date getReimbResolved() {
		return reimbResolved;
	}

	public void setReimbResolved(Date date) {
		this.reimbResolved = date;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public String getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(String reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public String getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(String reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public String getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}
	
	
	
	

}
