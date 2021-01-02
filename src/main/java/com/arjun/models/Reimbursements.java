package com.arjun.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reimbursements {

	private int reimb_ID;
	private double reimbAmount;
	private String reimbSubmitted;
	private String reimbResolved;
	private String reimbDescription;
	private int reimbAuthorID;
	private int reimbResolverID;
	private int reimbStatusID;
	private int reimbTypeID;
	private String image;
	
	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Reimbursements() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reimbursements(int reimb_ID, double reimbAmount, String reimbSubmitted, String reimbResolved,
			String reimbDescription, int reimbAuthorID, int reimbResolverID, int reimbStatusID, int reimbTypeID, String image) {
		super();
		this.reimb_ID = reimb_ID;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbAuthorID = reimbAuthorID;
		this.reimbResolverID = reimbResolverID;
		this.reimbStatusID = reimbStatusID;
		this.reimbTypeID = reimbTypeID;
		this.image = image;
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


	public String getReimbSubmitted() {
		return reimbSubmitted;
	}


	public void setReimbSubmitted(String string) {
		this.reimbSubmitted = string;
	}


	public String getReimbResolved() {
		return reimbResolved;
	}


	public void setReimbResolved(String string) {
		this.reimbResolved = string;
	}


	public String getReimbDescription() {
		return reimbDescription;
	}


	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}


	public int getReimbAuthorID() {
		return reimbAuthorID;
	}


	public void setReimbAuthorID(int reimbAuthorID) {
		this.reimbAuthorID = reimbAuthorID;
	}


	public int getReimbResolverID() {
		return reimbResolverID;
	}


	public void setReimbResolverID(int reimbResolverID) {
		this.reimbResolverID = reimbResolverID;
	}


	public int getReimbStatusID() {
		return reimbStatusID;
	}


	public void setReimbStatusID(int reimbStatusID) {
		this.reimbStatusID = reimbStatusID;
	}


	public int getReimbTypeID() {
		return reimbTypeID;
	}


	public void setReimbTypeID(int reimbTypeID) {
		this.reimbTypeID = reimbTypeID;
	}
	
	
	
	
	
	
	
}
