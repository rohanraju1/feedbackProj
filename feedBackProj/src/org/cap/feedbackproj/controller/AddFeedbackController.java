package org.cap.feedbackproj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.cap.feedbackproj.dto.FeedBackDTO;
import org.cap.feedbackproj.service.ViewAddFeedBack;

@WebServlet("/addFeedback")
public class AddFeedbackController extends HttpServlet {

	/*Add Feedback Form Data is Processed Here*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session!=null)
		{
		String courseName=req.getParameter("courseName");
		String	facultyName=req.getParameter("facultyName");
		int pr1=Integer.parseInt(req.getParameter("pr1"));
		int	clr1=Integer.parseInt(req.getParameter("clr1"));
		int tm1=Integer.parseInt(req.getParameter("tm1"));
		int	hnd1=Integer.parseInt(req.getParameter("hnd1"));
		int	hwsw=Integer.parseInt(req.getParameter("hwsw"));
    	String	txtcommts=req.getParameter("txtcommts");
		String	txtsuggstn=req.getParameter("txtsuggstn");
		
		 Object f = session.getAttribute("userName");
		int pId=(int)f;
		 														// check whether values are not null
		if(courseName!=null&&facultyName!=null&&pr1!=0&&clr1!=0&&tm1!=0&&hnd1!=0&&hwsw!=0&&txtcommts!=null&&txtsuggstn!=null)
		{
		FeedBackDTO fBackDTO=new FeedBackDTO();
		fBackDTO.setCourseName(courseName);
		fBackDTO.setFacultyName(facultyName);
		fBackDTO.setPresentationCommunication(pr1);
		fBackDTO.setClarifyDoubts(clr1);
		fBackDTO.setTimeManagement(tm1);
		fBackDTO.setHandOuts(hnd1);
		fBackDTO.setNwSofthardware(hnd1);
		fBackDTO.setComments(txtcommts);
		fBackDTO.setSuggestions(txtsuggstn);
		fBackDTO.setParticipantId(pId);
		
		boolean status=ViewAddFeedBack.addFeedback(fBackDTO);     //Call the AddFaculty Service to access Dao
		

		    if(status)								//if Data added Display Response Positive
		    {
		    	resp.setContentType("text/html");
				PrintWriter out=resp.getWriter();
				out.println("<html><body>Added Feedback</body></html>");
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
		    
		}	
		
	}
	
}
