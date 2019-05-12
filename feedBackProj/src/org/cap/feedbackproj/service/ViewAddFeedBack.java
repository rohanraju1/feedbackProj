package org.cap.feedbackproj.service;

import java.util.Map;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.dto.EmployeeDTO;
import org.cap.feedbackproj.dto.FeedBackDTO;

public class ViewAddFeedBack {

	
	public static Map<CourseDTO,EmployeeDTO> getDataForViewAddFeedBack()
	{
		
		Map<CourseDTO,EmployeeDTO> getMap=null;
		
		DaoInf map=new DaoImpl();
		
		getMap=map.getViewAddFeedBack();
		
		return getMap;
	}
	
	public static boolean addFeedback(FeedBackDTO feedBackDTO) 
	{
		boolean addStat=false;
		
		DaoInf addFeed=new DaoImpl();
		
	addStat=addFeed.addFeedBack(feedBackDTO);
		
		return addStat;
		
	}
	
}
