package org.capG.feedBackProj.service;

import java.util.Iterator;
import java.util.List;

import org.capG.feedBackProj.dao.DaoImpl;
import org.capG.feedBackProj.dao.DaoInf;
import org.capG.feedBackProj.dto.EmployeeDTO;

public class ViewFaculty {

	       public static List getViewDetails()
	       {
	    	   List<EmployeeDTO> lst=null;
	    	   DaoInf d=new DaoImpl();
	    	   
	    	   try {
	 		  lst=d.viewFacultyAll();
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   e.printStackTrace();
	    	   }
	 		  return lst;
	 		  
	       }
           
	       public static EmployeeDTO getViewDetails(int fid)
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
	     

	    	   
		}


