package org.capG.feedBackProj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
	        HttpSession session=req.getSession(false);
	        if(session!=null)
	        {
	        	session.invalidate();
	        }
	        Cookie[] cookie=req.getCookies();
	       
	   if(cookie !=null)
	   {
	        for(Cookie c:cookie)
	        {
	            if (c.getName().equals("JSESSIONID"))
	            {
				c.setMaxAge(0);
		        }
	        }
	  }
}
	
}
