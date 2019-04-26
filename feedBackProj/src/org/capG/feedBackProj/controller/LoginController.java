package org.capG.feedBackProj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.capG.feedBackProj.service.ValService;


public class LoginController extends HttpServlet
{
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
       {
    	   
    	     int Username=Integer.parseInt(req.getParameter("un"));
    	     String Password=req.getParameter("pwd");
    	     
                String role =ValService.loginValidate(Username, Password);
                 
                 HttpSession session=req.getSession();
                 System.out.println(role);
                 if(session!=null)
                 {
                	 
                   if(role.equals("TRAdmin"))
             {	     session.setAttribute("userName",Username);  
                RequestDispatcher rd=req.getRequestDispatcher("./HomePageAdmin.jsp");
    	    	 rd.forward(req,resp);
    	     }
               if(role.equals("TRCord"))
               {    session.setAttribute("userName",Username); 
            	   RequestDispatcher rd=req.getRequestDispatcher("coOrd page");
      	    	 rd.forward(req,resp);
               }
    	    
               else if(role.equals("TRParticipant"))
               {
            	   session.setAttribute("userName",Username); 
            	   RequestDispatcher rd=req.getRequestDispatcher("TR partcipant page");
      	    	 rd.forward(req,resp);
               }
               else 
               {
            	   resp.sendRedirect("./Login.html"
            	   		+ "");
               }
               
                 }
       }
	
}
