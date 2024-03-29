package com.revature.services;

import java.util.List;

import com.revature.dao.EmplReimbDAO;
import com.revature.models.Reimbursement;


public class EmplReimbServicesImpl implements EmplReimbServices{
	
	EmplReimbDAO ed;
	public EmplReimbServicesImpl(EmplReimbDAO ed) {
		this.ed=ed;
	}
		@Override
		public Reimbursement createReimbursement(Reimbursement r) {
			
			return ed.createTicket(r);
		}

		@Override
		public void updateStatus(int reimbursementID, int statusID, int resolverID) {
			ed.updateStatus(reimbursementID, statusID, resolverID);
		}

		@Override
		public List<Reimbursement> findAllTickets() {
			
			return ed.findAll();
		}

		@Override
		public List<Reimbursement> findTicketByStatus(int statusID) {
			
			return ed.findAllByStatus(statusID);
		}

		@Override
		public List<Reimbursement> findTicketByUser(int userID) {
			
			return ed.findAllByUserID(userID);
		}

	}



