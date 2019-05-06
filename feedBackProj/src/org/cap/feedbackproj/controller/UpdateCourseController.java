package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.service.UpdateCourse;
import org.cap.feedbackproj.service.UpdateFaculty;

public class UpdateCourseController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uCourseId=Integer.parseInt(req.getParameter("ucid"));

		String uCourseName=req.getParameter("ucname");

		int uCourseDays=Integer.parseInt(req.getParameter("ucdays"));

		boolean UpStatus=false;
		if(uCourseId!=0&&uCourseName!=null&&uCourseDays!=0)     // check whether values are not null
		{
			/*Call the UpdateCourse service to access Dao*/
			UpStatus=UpdateCourse.updateCourseDetails(uCourseId,uCourseName,uCourseDays);  

			if(UpStatus)                           //if Data updated Display Response Positive
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Updated Course</body></html>");
				out.close();
			}
			else                                  //if Data Not updated Display Response Negative
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Course Not Updated</body></html>");
				out.close();
			}

		}
		else {
			 resp.setContentType("text/html");
    	     PrintWriter out=resp.getWriter();
    	     out.println("<html><body>Values are null</body></html>");
    	     out.close();
		}
	}

}
