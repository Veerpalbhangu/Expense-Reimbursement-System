package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.exceptions.AbstractHttpException;
import com.revature.util.LoggerSingleton;

public class ErrorController {
	public void handle(HttpServletRequest req, HttpServletResponse res, Throwable t) throws IOException {
	
		if (t == null) {
			res.setStatus(500);
			res.getWriter().write("OOPS something went wrong");
			return;
		}

		
		if (t instanceof AbstractHttpException) {

			AbstractHttpException err = (AbstractHttpException) t;
			System.out.println(t.getMessage());
			res.setStatus(err.getStatusCode());
			res.getWriter().write(err.getMessage());

		} else {
			t.printStackTrace();
			LoggerSingleton.getLogger().error(t.getStackTrace());
			res.setStatus(500);
			res.getWriter().write("OOPS something went wrong");
		}

	}
}
