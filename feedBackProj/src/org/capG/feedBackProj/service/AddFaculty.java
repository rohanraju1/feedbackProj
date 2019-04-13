package org.capG.feedBackProj.service;

import org.capG.feedBackProj.dao.DaoImpl;
import org.capG.feedBackProj.dto.FacultyDTO;

public class AddFaculty {

	
	
	public static boolean name(int faculty_Id, String faculty_Name,String skill)
	{
		
		   DaoImpl d1=new DaoImpl();
 		  /* setting data to dto*/
 	     FacultyDTO facultyDTO=new FacultyDTO();
 	     facultyDTO.setFacultyId(faculty_Id);
 	     facultyDTO.setSkills(skill);
 	     return d1.saveFacultyDetails(facultyDTO);
 	  
	}
	
	
}
