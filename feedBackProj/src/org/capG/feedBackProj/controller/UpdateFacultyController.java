package org.capG.feedBackProj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.capG.feedBackProj.service.UpdateFaculty;
import org.capG.feedBackProj.service.ValService;

@WebServlet("/updateFaculty")
public class UpdateFacultyController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	       int updateFid=Integer.parseInt(req.getParameter("Upid"));
	       String updateFname=req.getParameter("Upname");
	       String updateSkills[]=req.getParameterValues("Upskills");
	
	       String upSkill=String.join(",",updateSkills);
	       
	       if(updateFid!=0&&updateFname!=null)
		      { 
		        	if(ValService.userValidate(updateFid,updateFname))
		    	  { 
		        		/* Go to Service class and do main operation*/       
		    		  
		    	   boolean saveStatus=UpdateFaculty.updateDetails(updateFid,upSkill);
		    	   System.out.println(saveStatus);
		    	  }
	                     resp.sendRedirect("./updateFaculty.html");
		      }  
	       }
	
}
