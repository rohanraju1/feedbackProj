package org.capG.feedBackProj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capG.feedBackProj.service.ValService;

public class ViewFacultyController extends HttpServlet {
	
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  
	      String name=req.getParameter("viewBased");
	      
	       if(name.equals("FacultyId"))
	       {
	    	   ValService.getFacultyById(1);
	       }
	         
	  
	  
	  }

}
