package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.CourseDTO;

public class AddCourse {

	/*This method will return boolean value whether data is added with help of DAO*/
	   public static boolean addCourse(int courseId,String courseName,int courseDays)
	   {
		   boolean addStatus=false;
		   
		   DaoInf add=new DaoImpl();
		   
		   CourseDTO courseDTO=new CourseDTO();
		   
		   courseDTO.setCourseId(courseId);
		   courseDTO.setCourseName(courseName);
		   courseDTO.setNoOfDays(courseDays);
		   
		addStatus=add.addCourse(courseDTO);   //Access DataBase to add course with DAO
		   
		   
		   return addStatus;
	   }
	
}
