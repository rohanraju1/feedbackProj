package org.cap.feedbackproj.service;

import java.util.List;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.CourseDTO;

public class ViewCourse
{
	/*Return List Object From DAO*/
	public static List<CourseDTO> getCourses()
	{
        DaoInf viewCourses=new DaoImpl();
		List<CourseDTO> cList=null;
		
		try {
		   cList=viewCourses.viewCourses();//Access DataBase with the help of DAO to return all Course Data
		} catch (Exception e) {
              e.printStackTrace();
		}
		return cList;
	}
	
}
