package org.capG.feedBackProj.service;

import org.capG.feedBackProj.dao.DaoImpl;
import org.capG.feedBackProj.dao.DaoInf;
import org.capG.feedBackProj.dto.EmployeeDTO;
import org.capG.feedBackProj.dto.FacultyDTO;

public class UpdateFaculty {

	
	public static boolean updateDetails(int updateFid, String upSkill) {
	
		boolean Upstatus=false;
		
		DaoInf d3=new DaoImpl();
		
		FacultyDTO facultyDTO=new FacultyDTO();
	     facultyDTO.setFacultyId(updateFid);
	     facultyDTO.setSkills(upSkill);
		 
		Upstatus=d3.updateFacultyDetails(facultyDTO);
	  System.out.println(Upstatus);	
		return Upstatus;
	
	}
	
	
}
