package org.cap.feedbackproj.service;


import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.EmployeeDTO;

public class ValService {

	/*Login data is validated here */
	public static String loginValidate(int vusername, String vpassword) {

		EmployeeDTO dto=null;
		DaoInf impl1=new DaoImpl();
		dto=impl1.getLoginData(vusername,vpassword);   //check for the data in Database with the help of Dao

		String roleReturned=dto.getRole();


		return roleReturned ;          //return the role of the user 

	}


	public static boolean userValidate(int fid,String fname)
	{
		boolean status=false;

		EmployeeDTO edto;

		DaoInf impl2=new DaoImpl();

		edto=impl2.getEmployeeDetails(fid, fname);

		int vfid=edto.getEmployeeId();
		String vfname=edto.getEmployeeName();
		System.out.println(vfid);
		System.out.println(vfname);
		System.out.println(fname);
		if (fname.equals(vfname))
		{
			status=true;
		}
		System.out.println(status);
		return status;
	}


	//	public static EmployeeDTO getFacultyById(int fId) 
	//	{
	//		return null;
	//	}
}
