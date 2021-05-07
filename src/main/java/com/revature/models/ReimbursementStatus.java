package com.revature.models;

public class ReimbursementStatus {
private int reimbursementId;
private String status;


public ReimbursementStatus() {
	super();
	// TODO Auto-generated constructor stub
}
public ReimbursementStatus(int reimbursementId, String status) {
	super();
	this.reimbursementId = reimbursementId;
	this.status = status;
}
public int getReimbursementId() {
	return reimbursementId;
}
public void setReimbursementId(int reimbursementId) {
	this.reimbursementId = reimbursementId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
