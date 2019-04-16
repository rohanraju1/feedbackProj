package org.capG.feedBackProj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capG.feedBackProj.dao.DaoImpl;
import org.capG.feedBackProj.dto.EmployeeDTO;
import org.capG.feedBackProj.dto.FacultyDTO;
import org.capG.feedBackProj.service.AddFaculty;
import org.capG.feedBackProj.service.ValService;


public class AddFacultyController extends HttpServlet
{ 
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		  int faculty_Id=Integer.parseInt(req.getParameter("fid"));
	       String faculty_Name=req.getParameter("fname");
	       String[] skills=req.getParameterValues("skills");
	     
	             String skill=String.join(",",skills);
	        if(faculty_Id!=0&&faculty_Name!=null)
	      { 
	        	if(ValService.userValidate(faculty_Id, faculty_Name))
	    	  { 
	        		/* Go to Service class and do main operation*/       
	    		  
	    	   boolean saveStatus= AddFaculty.name(faculty_Id, faculty_Name, skill);
	    	   
	    	   if(saveStatus) {
	    	      resp.setContentType("text/html");
	    	     PrintWriter out=resp.getWriter();
	    	     out.println("<html><body>Added Faculty</body></html>");
	    	     out.close();
	    	   }
	    	   else {
		    		  resp.setContentType("text/html");
			    	     PrintWriter out=resp.getWriter();
			    	     out.println("<html><body>Something went Wrong</body></html>");
			    	     out.close();
			    	  
				}
	    	  }  
	      }
	      else 
	      {
	    	  System.out.println("facId and facname null");
	      }
	
	}
}
