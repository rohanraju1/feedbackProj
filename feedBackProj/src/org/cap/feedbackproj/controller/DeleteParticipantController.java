package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.service.DeleteParticipant;

public class DeleteParticipantController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	      int trainingCode=Integer.parseInt(req.getParameter("tCode"));
	      int participantCode=Integer.parseInt(req.getParameter("pCode"));
	      String participantName=req.getParameter("pName");
	      
	      if(trainingCode!=0&&participantCode!=0&&participantName!=null)
	      {																		//Call the DeleteParticipant Service to access Dao
	    	  boolean deleteStatus=DeleteParticipant.delParticipant(trainingCode,participantCode,participantName);
	    	  
	    	  if(deleteStatus)						//if Data Deleted Display Response Positive
	    	  {
	    		  resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.println("<html><body>Deleted Participant</body></html>");
					out.close(); 
	    		  
	    	  }
	    	  else 										//if Data not Deleted give Negative Response
	    	  {
	    		  resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.println("<html><body>Not Deleted Participant</body></html>");
					out.close();
	    		  
	    	  }
	      }
	      else											//if Some values are not present or null
	      {
	    	  resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Values are null</body></html>");
				out.close();
	      }
	
	}
	
}
