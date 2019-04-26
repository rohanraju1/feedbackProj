package org.capG.feedBackProj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.capG.feedBackProj.dto.EmployeeDTO;
import org.capG.feedBackProj.service.ViewFaculty;


public class ViewFacultyController extends HttpServlet {
	
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	  HttpSession session=req.getSession();
	        
	  if(session!=null)
	  {
		 List<EmployeeDTO> lst=ViewFaculty.getViewDetails();
	      req.setAttribute("datalist",lst);
	      RequestDispatcher rd=req.getRequestDispatcher("./ViewFaculty.jsp");
	      rd.forward(req, resp);
	  }
	         
	  
	  
	  }

}
