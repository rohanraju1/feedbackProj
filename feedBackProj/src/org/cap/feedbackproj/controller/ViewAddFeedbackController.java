package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.dto.EmployeeDTO;
import org.cap.feedbackproj.service.ViewAddFeedBack;

@WebServlet("/viewAddFeedBack")
public class ViewAddFeedbackController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<CourseDTO,EmployeeDTO> viewMap=ViewAddFeedBack.getDataForViewAddFeedBack();
	
					req.setAttribute("mapData",viewMap);
					
      RequestDispatcher rd=req.getRequestDispatcher("./AddFeedBack.jsp");
      				rd.forward(req, resp);
	}
	
}
