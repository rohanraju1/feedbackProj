package org.cap.feedbackproj.service;

import java.util.List;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.EmployeeDTO;

public class ViewFaculty {

	
	        /*Return List Object From DAO*/
	       public static List<EmployeeDTO> getViewDetails()
	       {
	    	   List<EmployeeDTO> lst=null;
	    	   DaoInf d=new DaoImpl();
	    	   
	    	   try {
	 		  lst=d.viewFacultyAll();   //Access DataBase with the help of DAO to return all Employee Data
	 		                                  //Note If he's an Employee thn  he's a Faculty  
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	 		  return lst;
	 		  
	       }
           
/*	       public static EmployeeDTO getViewDetails(int fid)
	       {
	    	   EmployeeDTO edto=null;
	    	   DaoInf d=new DaoImpl();
	    	   
	    	   try {
	 		  edto=d.viewFaculty(fid);
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	 		  return edto;
	 		   
	       }
*/	     

	    	   
		}


