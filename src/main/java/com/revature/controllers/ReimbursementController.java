package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmplReimbPostgresDAO;
import com.revature.models.Reimbursement;
import com.revature.services.EmplReimbServices;
import com.revature.services.EmplReimbServicesImpl;


public class ReimbursementController {

	private EmplReimbServices ers=new EmplReimbServicesImpl (new EmplReimbPostgresDAO()); 
	private ObjectMapper om=new ObjectMapper();
	
	public void findAllTickets(HttpServletRequest req, HttpServletResponse res)throws IOException{
		List<Reimbursement> allReimb=ers.findAllTickets();
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allReimb));
	}
	
	public void findTicketByUserID(HttpServletRequest req, HttpServletResponse res, int userID) throws IOException{
		List<Reimbursement> r=ers.findTicketByUser(userID);
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));	
	}
	
	public void updateStatus(HttpServletRequest req, HttpServletResponse res,int statusID)throws IOException {
		ObjectMapper om=new ObjectMapper();
		Reimbursement r=om.readValue(req.getInputStream(),Reimbursement.class);
		ers.updateStatus(r.getReimbursementID(),r.getReimbursementResolverId(), statusID);
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(r));
	}
	
	public void createTicket(HttpServletRequest req, HttpServletResponse res) throws IOException{
		ObjectMapper om=new ObjectMapper();
		Reimbursement r=om.readValue(req.getInputStream(), Reimbursement.class);
	ers.createReimbursement(r);
	res.setStatus(200);
	res.getWriter().write(om.writeValueAsString(r));
	}
	
	public void findTicketByStatus(HttpServletRequest req, HttpServletResponse res, int statusID) throws IOException{
		List<Reimbursement> reimb=ers.findTicketByStatus(statusID);
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(reimb));
	}
}
