package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cap.feedbackproj.dto.ParticipantDTO;
import org.cap.feedbackproj.service.ViewParticipant;

public class ViewParticipantController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
		HttpSession session=req.getSession();

		if(session!=null)
		{

			List<ParticipantDTO> partLst=ViewParticipant.getParticipant();   //Call View Participant Sevice to get Data as List Object

			req.setAttribute("partcipList",partLst);         //set list Object to Request Object Scope with Attribute
			RequestDispatcher rd=req.getRequestDispatcher("./ViewParticipant.jsp"); //Redirect to ViewParticipant.jsp to show all Data
			rd.forward(req, resp);
		}	
	
	}
	
}
