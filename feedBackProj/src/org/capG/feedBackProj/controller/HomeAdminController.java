package org.capG.feedBackProj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeAdminController  extends HttpServlet
{
                       /* Redirect the request to Faculty Skill Maintenance Page*/
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
	   RequestDispatcher rd=req.getRequestDispatcher("./FacultySkillMain.html");
       rd.forward(req, resp);
  
   }
}
