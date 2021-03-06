package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.service.ViewCourse;


public class ViewCourseController extends HttpServlet {


	/*View course Form event is processed*/

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();

		if(session!=null)
		{

			List<CourseDTO> clst=ViewCourse.getCourses();          //Call View Course Sevice to get Data as List Object

			req.setAttribute("courselst",clst);         //set list Object to Request Object Scope with Attribute
			RequestDispatcher rd=req.getRequestDispatcher("./ViewCourse.jsp"); //Redirect to ViewCourse.jsp to show all Data
			rd.forward(req, resp);
		}



	}
}
