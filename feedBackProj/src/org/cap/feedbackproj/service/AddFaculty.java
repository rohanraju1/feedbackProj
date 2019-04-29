package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.FacultyDTO;

public class AddFaculty {

	  
	/*This method will return boolean value whether data is added with help of DAO*/
	
	public static boolean addFaculty(int faculty_Id, String faculty_Name,String skill)
	{
		
		   DaoInf d1=new DaoImpl();
 		  /* setting data to dto*/
 	     FacultyDTO facultyDTO=new FacultyDTO();
 	     facultyDTO.setFacultyId(faculty_Id);
 	     facultyDTO.setSkills(skill);
 	     return d1.saveFacultyDetails(facultyDTO);    //Access DataBase to add Faculty with DAO
 	  
	}

	
	
}
