package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.service.UpdateTProgram;

public class UpdateTrainingProgramController extends HttpServlet {


	/*Update Training Program Form Data is Processed Here*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int trainingCode=Integer.parseInt(req.getParameter("tCode"));
		String facultyName=req.getParameter("fName");
		String edDate=req.getParameter("eDate");

		Date endDate=Date.valueOf(edDate);

		if(trainingCode!=0&&facultyName!=null&&endDate!=null)              // check whether values are not null
		{
			boolean updStatus=UpdateTProgram.updatePrgm(trainingCode,facultyName,endDate);

			if(updStatus)													//if Data Updated Display Response Positive
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Updated Course</body></html>");
				out.close();
			}
			else 														//if Data not Updated give Negative Response
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Something Went Wrong</body></html>");
				out.close();
			}

		}
		else
		{															//if data is not present or null
			 resp.setContentType("text/html");
	   	     PrintWriter out=resp.getWriter();
	   	     out.println("<html><body>Values are null</body></html>");
	   	     out.close();
		}
	}

}
