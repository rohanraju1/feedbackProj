package org.capG.feedBackProj.service;

import java.util.Iterator;
import java.util.List;

import org.capG.feedBackProj.dao.DaoImpl;
import org.capG.feedBackProj.dao.DaoInf;
import org.capG.feedBackProj.dto.EmployeeDTO;

public class ViewFaculty {

	
	        /*Return List Object From DAO*/
	       public static List getViewDetails()
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


