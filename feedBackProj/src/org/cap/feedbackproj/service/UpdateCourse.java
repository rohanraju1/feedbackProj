package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.CourseDTO;

public class UpdateCourse {

	/*This method will return boolean value whether value is updated with the help of DAO*/
	public static boolean updateCourseDetails(int uCourseId, String uCourseName, int uCourseDays) {

		boolean updateCourse=false;

		DaoInf updte=new DaoImpl();

		CourseDTO courseDTO=new CourseDTO();

		courseDTO.setCourseId(uCourseId);
		courseDTO.setCourseName(uCourseName);
		courseDTO.setNoOfDays(uCourseDays);

		updateCourse=updte.updateCourse(courseDTO);        //Access DataBase to update Course with DAO

		return updateCourse;
	}


}
