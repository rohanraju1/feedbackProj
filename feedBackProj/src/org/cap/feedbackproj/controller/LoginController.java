package org.cap.feedbackproj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.cap.feedbackproj.service.ValService;


public class LoginController extends HttpServlet
{                       
	              /* Login form data is being processed */
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
       {
    	   
    	     int Username=Integer.parseInt(req.getParameter("un"));
    	     String Password=req.getParameter("pwd");
    	     
    	                                                                     
                String role =ValService.loginValidate(Username, Password);          //Go to ValService class for authentication & get Role
                 
                 HttpSession session=req.getSession();
                 System.out.println(role);
                 if(session!=null)
                 {
                	                                   /*verify the User role and give access*/ 
                   if(role.equals("TRAdmin"))
             {	     session.setAttribute("userName",Username);  
                RequestDispatcher rd=req.getRequestDispatcher("./HomeTrAdmin.html");   //go to Home Page of Admin
    	    	 rd.forward(req,resp);
    	     }
               if(role.equals("TRCord"))
               {    session.setAttribute("userName",Username); 
            	   RequestDispatcher rd=req.getRequestDispatcher("./HomeTrCoord.html");		//go to Home Page of Co-ordinator
      	    	 rd.forward(req,resp);
               }
    	    
               else if(role.equals("TRParticipant"))
               {
            	   session.setAttribute("userName",Username); 
            	   RequestDispatcher rd=req.getRequestDispatcher("./HomeTParticipant.html");	//go to Home Page of Participant
      	    	 rd.forward(req,resp);
               }
            
               
                 }
                 else 
                 {
              	   resp.sendRedirect("./Login.html"			//redirect to Login page if none of the roles matched
              	   		+ "");
                 }
       }
	
}
