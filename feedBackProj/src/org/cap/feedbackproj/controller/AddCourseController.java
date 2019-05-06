package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.service.AddCourse;


public class AddCourseController extends HttpServlet {

	/*Add Course Form Data is Processed Here*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int courseId=Integer.parseInt(req.getParameter("cid"));
		String courseName=req.getParameter("cname");
		int courseDays=Integer.parseInt(req.getParameter("cdays"));
		boolean addedStatus=false;
		if(courseId!=0&&courseName!=null&&courseDays!=0)     // check whether values are not null
		{
			addedStatus=AddCourse.addCourse(courseId, courseName, courseDays);
		


		if(addedStatus)                           //if Data added Display Response Positive
		{
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html><body>Added Course</body></html>");
			out.close();
		}
		else {                       				 //if Data not Added give Negative Response
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			out.println("<html><body>Something Went Wrong</body></html>");
			out.close();

		}
		}
		else                                                //if data is not present or null
		{
			 resp.setContentType("text/html");
   	     PrintWriter out=resp.getWriter();
   	     out.println("<html><body>Values are null</body></html>");
   	     out.close();
		}

	}

}
