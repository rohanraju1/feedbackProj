package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.FacultyDTO;

public class UpdateFaculty {

	/*This method will return boolean value whether value is updated with the help of DAO*/
	public static boolean updateDetails(int updateFid, String upSkill) {

		boolean Upstatus=false;

		DaoInf d3=new DaoImpl();

		FacultyDTO facultyDTO=new FacultyDTO();
		facultyDTO.setFacultyId(updateFid);
		facultyDTO.setSkills(upSkill);

		Upstatus=d3.updateFacultyDetails(facultyDTO);    //Access DataBase to update Faculty with DAO
		System.out.println(Upstatus);	
		return Upstatus;

	}


}
