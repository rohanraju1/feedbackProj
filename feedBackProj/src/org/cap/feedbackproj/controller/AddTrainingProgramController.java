package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.dto.TrainingProgramDTO;
import org.cap.feedbackproj.service.AddTProgram;

public class AddTrainingProgramController extends HttpServlet {

	/*Add Training Program Form Data is Processed Here*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int trainingCode=Integer.parseInt(req.getParameter("tCode"));
		String courseName=req.getParameter("cName");
		String facultyName=req.getParameter("fName");
		String strtDate=req.getParameter("sDate");
		String edDate=req.getParameter("eDate");

		Date startDate=Date.valueOf(strtDate);  /* Convert the received String values of date with Date.valueOf() method*/
		Date endDate=Date.valueOf(edDate);

		if(trainingCode!=0&&courseName!=null&&facultyName!=null&&startDate!=null&&endDate!=null) // check whether values are not null
		{
			TrainingProgramDTO tDTO=new TrainingProgramDTO();
			tDTO.setTrainingCode(trainingCode);
			tDTO.setCourseName(courseName);
			tDTO.setFacultyName(facultyName);
			tDTO.setsDate(startDate);
			tDTO.seteDate(endDate);

			boolean addStatus=AddTProgram.addProgram(tDTO);       //Call the AddTProgram Service to access Dao

			if(addStatus)              //if Data added Display Response Positive
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Added Program</body></html>");
				out.close(); 
			}
			else                    //if Data not Added give Negative Response
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Not Added Program</body></html>");
				out.close();
			}
		}
		else             //if Some values are not present or null
		{
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html><body>Values are null</body></html>");
			out.close();
		}


	}
}
