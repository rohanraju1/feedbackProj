 package org.capG.feedBackProj.service;

import java.util.ArrayList;
import java.util.List;

import org.capG.feedBackProj.dao.DaoImpl;
import org.capG.feedBackProj.dao.DaoInf;
import org.capG.feedBackProj.dto.EmployeeDTO;
import org.capG.feedBackProj.dto.FacultyDTO;

public class ValService {

	public static String loginValidate(int vusername, String vpassword) {
		
		EmployeeDTO dto=null;
		DaoInf impl1=new DaoImpl();
		dto=impl1.getLoginData(vusername,vpassword);
		
		String roleReturned=dto.getRole();
		
		
		return roleReturned ;
		
   	}

	
	public static boolean userValidate(int fid,String fname)
	{
	   boolean status=false;
	   
	   EmployeeDTO edto=null;
	   DaoInf impl2=new DaoImpl();
	   
	   edto=impl2.getEmployeeDetails(fid, fname);
	   
	   int vfid=edto.getEmployeeId();
	   String vfname=edto.getEmployeeName();
	   
	   if (fid==vfid&&fname.equals(vfname))
	   {
		    status=true;
	}
	   	return status;
	}


	public static EmployeeDTO getFacultyById(int fId) 
	{
		return null;
	}
}
