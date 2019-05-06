package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.dto.TrainingProgramDTO;
import org.cap.feedbackproj.service.ViewTProgram;

public class ViewTrainingProgramController extends HttpServlet {

	/*View Programs Form event is processed*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		List<TrainingProgramDTO> tpLst=ViewTProgram.getPrograms();          //Call ViewTProgram Service to get Data as List Object

		req.setAttribute("prgmList",tpLst);         //set list Object to Request Object Scope with Attribute
		RequestDispatcher rd=req.getRequestDispatcher("./ViewProgram.jsp"); //Redirect to ViewT.jsp to show all Data
		rd.forward(req, resp);


	}

}
