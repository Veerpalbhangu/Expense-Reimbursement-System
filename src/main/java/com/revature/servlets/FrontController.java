package com.revature.servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.ErrorController;
import com.revature.controllers.ReimbursementController;
import com.revature.controllers.UserController;



public class FrontController extends HttpServlet {
	private ErrorController errorController = new ErrorController();
	private UserController userController=new UserController();
	private ReimbursementController reimbursementController= new ReimbursementController();
	
	protected void directControlRouter(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//how to get a value from your init params
		/*System.out.println(this.getInitParameter("DefaultRole"));
		ServletContext sc = this.getServletContext();
		
		System.out.println(sc.getInitParameter("JavaCoolFactor"));
		*/
		//be our front controller
		String URI = req.getRequestURI().substring(req.getContextPath().length(), 
													req.getRequestURI().length());
		String value="";
		Pattern pattern=Pattern.compile("\\d+$");
		System.out.println("req.getRequestURI() : " + req.getRequestURI());
		Matcher matcher=pattern.matcher(req.getRequestURI());
		boolean isMatch=matcher.find();
		System.out.println("isMatch: " + isMatch);
		if(isMatch) {
			value=matcher.group(0);
		}
		if(isMatch) {
			if(req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length()-value.length()-1).equalsIgnoreCase("/reimb")) {
		switch(req.getMethod()) {
		case "GET":
			reimbursementController.findTicketByStatus(req, res, Integer.parseInt(value));
			break;
		case "POST":
			res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
		case "PUT":
			res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
		case "DELETE":
			res.setStatus(400); res.getWriter().write("Method Not Supported");	break;
		default:
			res.setStatus(400); res.getWriter().write("Method Not Supported");	break;
	}
			}
			else if(req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length()-2).equalsIgnoreCase("/update")) {
				switch (req.getMethod()) {
				case "GET":
					res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
				case "POST":
					res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
				case "PUT":
					reimbursementController.updateStatus(req, res, Integer.parseInt(value));
					break;
				case "DELETE":
					res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
				default:
					res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
				}
			}
		else if (req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length()-value.length()-1).equalsIgnoreCase("/viewHistory")) {
			switch (req.getMethod()) {
			case "GET":
				reimbursementController.findTicketByUserID(req, res, Integer.parseInt(value));
				break;
			case "POST":
				res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
			case "PUT":
				res.setStatus(400);	res.getWriter().write("Method Not Supported");	break;
			case "DELETE":
				res.setStatus(400); res.getWriter().write("Method Not Supported");	break;
			default:
				res.setStatus(400); res.getWriter().write("Method Not Supported");	break;
			}
		}
		} else {
		System.out.println(URI);
		switch (URI) {
			case "/login":{
				switch (req.getMethod()) {
					case "GET":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "POST":{
						userController.userLogin(req, res);
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				
				}
				break;
			}
			case "/viewAllTickets": {
				switch (req.getMethod()) {
					case "GET":{
						reimbursementController.findAllTickets(req, res);
						break;
					}
					case "POST":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "PUT":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					case "DELETE":{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
					default:{
						res.setStatus(400);
						res.getWriter().write("Method Not Supported");
						break;
					}
				}
				break;
			}
			case "/newReimb":{
				switch (req.getMethod()) {
				case "GET":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "POST":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "PUT":{
					reimbursementController.createTicket(req, res);
					res.setStatus(200);
					break;
				}
				case "DELETE":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
			}
			break;
			}
			case "/viewByAuthor":{
				switch (req.getMethod()) {
				case "GET":{
					reimbursementController.findTicketByUserID(req, res, 1);
					break;
				}
				case "POST":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "PUT":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
			}
			break;
			}
			case "/filterByStatus":{
				switch (req.getMethod()) {
				case "GET":{
					//TODO
					break;
				}
				case "POST":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "PUT":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				case "DELETE":{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
				default:{
					res.setStatus(400);
					res.getWriter().write("Method Not Supported");
					break;
				}
			}
			break;
			}
			default:{
				res.setStatus(404);
				res.getWriter().write("No Such Resource");
				break;
			}
			
		}
		
		}
		
	}
	
	
	protected void directControl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//to handle all internal errors/exceptions
		try {
			directControlRouter(request, response);
		}catch (Throwable t) {
			//errorController.handle(request, response, t);//go to the error controller// change here
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		directControl(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
