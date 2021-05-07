package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;

public interface EmplReimbServices {
	
	public Reimbursement createReimbursement(Reimbursement r);
	public void updateStatus(int reimbursementID, int statusID, int resolverID);
	public List<Reimbursement> findAllTickets();
	public List<Reimbursement> findTicketByStatus(int statusID);
	public List<Reimbursement> findTicketByUser(int userID);
}


