package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dto.EmployeeDTO;
import org.cap.feedbackproj.dto.FacultyDTO;
import org.cap.feedbackproj.service.AddFaculty;
import org.cap.feedbackproj.service.ValService;


public class AddFacultyController extends HttpServlet
{ 
	/*Add Faculty Form Data is Processed Here*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		int faculty_Id=Integer.parseInt(req.getParameter("fid"));
		String faculty_Name=req.getParameter("fname");
		String[] skills=req.getParameterValues("skills");

		String skill=String.join(",",skills);     //Join the array values with separated commas
		if(faculty_Id!=0&&faculty_Name!=null)            // check whether values are not null
		{ 
			if(ValService.userValidate(faculty_Id, faculty_Name))  //validate the User if he's a Faculty    
			{ 
				/* Go to Service class and do main operation*/       

				boolean saveStatus= AddFaculty.addFaculty(faculty_Id, faculty_Name, skill);  //Call the AddFaculty Service to access Dao

				if(saveStatus)                              //if Data added Display Response Positive
				{         
					resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.println("<html><body>Added Faculty</body></html>");
					out.close();
				}
				else                                           //if Data not Added give Negative Response
				{                                         
					resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.println("<html><body>Something Went Wrong</body></html>");
					out.close();

				}
			}  
			else                                           // if he's not faculty give appropriate Response
			{
				resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Not a Faculty</body></html>");
				out.close();
			}
		}
		else    
		{
			System.out.println("facId and facname null");
		}

	}
}
