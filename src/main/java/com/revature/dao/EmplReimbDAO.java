package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface EmplReimbDAO {
	
public Reimbursement createTicket(Reimbursement reimbTicket);

public List<Reimbursement> findAllByUserID(int userID);

public List<Reimbursement> findAllByStatus(int statusID);

public List<Reimbursement> findAll();

public void updateStatus(int reimbID, int statusID, int resolverID);


}