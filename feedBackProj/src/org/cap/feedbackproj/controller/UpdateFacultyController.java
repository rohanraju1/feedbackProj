package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.service.UpdateFaculty;
import org.cap.feedbackproj.service.ValService;

@WebServlet("/updateFaculty")
public class UpdateFacultyController extends HttpServlet {

                  	/*Update Form Data is Processed Here*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	       int updateFid=Integer.parseInt(req.getParameter("Upid"));
	       String updateFname=req.getParameter("Upname");
	       String updateSkills[]=req.getParameterValues("Upskills");
	
	       String upSkill=String.join(",",updateSkills);           //Join the array values with separated commas
	                                              
	       if(updateFid!=0&&updateFname!=null)    // check whether values are not null
		      { 
		        	if(ValService.userValidate(updateFid,updateFname))         //validate the User if he's a Faculty 
		    	  { 
		        		     
		    		  /*Call the UpdateFaculty Service to access Dao*/
		    	   boolean saveStatus=UpdateFaculty.updateDetails(updateFid,upSkill);
		    	   
		    	   if (saveStatus)                          //if Data added Display Response Positive
		    	   {
		    		   resp.sendRedirect("./updateFaculty.html");
				   }  
		    	   else                                  //if Data not Added give Negative Response
		    	   {
		    		   resp.setContentType("text/html");
			    	     PrintWriter out=resp.getWriter();
			    	     out.println("<html><body>Something Went Wrong</body></html>");
			    	     out.close();
				   }
		    	   
		    	   
		    	  }
		   else                                                // if he's not faculty give appropriate Response
		       	{
		        		 resp.setContentType("text/html");
			    	     PrintWriter out=resp.getWriter();
			    	     out.println("<html><body>not a Faculty</body></html>");
			    	     out.close();
		       	}
	                   
		      }  
	      else                                      
	       {
	    	  resp.setContentType("text/html");
	    	     PrintWriter out=resp.getWriter();
	    	     out.println("<html><body>Values are null</body></html>");
	    	     out.close();
	       }
	       
	       }
	
}
