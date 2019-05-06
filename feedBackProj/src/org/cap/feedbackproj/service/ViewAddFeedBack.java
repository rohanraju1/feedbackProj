package org.cap.feedbackproj.service;

import java.util.Map;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.dto.EmployeeDTO;

public class ViewAddFeedBack {

	
	public static Map<CourseDTO,EmployeeDTO> getDataForViewAddFeedBack()
	{
		
		Map<CourseDTO,EmployeeDTO> getMap=null;
		
		DaoInf map=new DaoImpl();
		
		getMap=map.getViewAddFeedBack();
		
		return getMap;
	}
	
	
	
}
