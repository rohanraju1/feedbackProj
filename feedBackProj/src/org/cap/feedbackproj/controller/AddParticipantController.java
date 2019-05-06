package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.service.AddParticipant;

public class AddParticipantController extends HttpServlet{

      
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	      int trainingCode=Integer.parseInt(req.getParameter("tCode"));
	      int participantCode=Integer.parseInt(req.getParameter("pCode"));
	      
	      String participantName=req.getParameter("pName");
	      String courseName=req.getParameter("cName");
	      
	     if(trainingCode!=0&&participantCode!=0&&participantName!=null&&courseName!=null)
	     {
	      
	      boolean addParticipant=AddParticipant.saveParticipant(trainingCode,participantCode,participantName,courseName);
	      
	           if (addParticipant) 
	           {
	        	   resp.setContentType("text/html");
	   			PrintWriter out=resp.getWriter();
	   			out.println("<html><body>Added Participant</body></html>");
	   			out.close();
			   } 
	           else
	           {
	        	   resp.setContentType("text/html");
	   			PrintWriter out=resp.getWriter();
	   			out.println("<html><body>Something Went Wrong</body></html>");
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
