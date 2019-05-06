package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.service.DeleteTProgram;

public class DeleteTrainingProgramController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int trainingCode=Integer.parseInt(req.getParameter("tCode"));

		if(trainingCode!=0)
		{
			boolean status=false;

			status=DeleteTProgram.deletePrgm(trainingCode); 	//Call the DeleteTProgram Service to access Dao

			if (status) {							//if Data Deleted Display Response Positive
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Deleted Program</body></html>");
				out.close(); 
			} else {										//if Data not Deleted give Negative Response
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Not Deleted Program</body></html>");
				out.close();
			}
		}
		else {									//if Some values are not present or null
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html><body>Values are null</body></html>");
			out.close();
		}

	}



}
