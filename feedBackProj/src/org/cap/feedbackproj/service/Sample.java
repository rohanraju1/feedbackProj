package org.cap.feedbackproj.service;

import java.util.HashMap;
import java.util.Map;

import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.dto.EmployeeDTO;

public class Sample {

	
	public static void main(String[] args) {
		
		CourseDTO dto=new CourseDTO();
		dto.setCourseName("a");
		CourseDTO dto1=new CourseDTO();
		dto1.setCourseName("b");
		
		EmployeeDTO edto=new EmployeeDTO();
		edto.setEmployeeName("A");
		EmployeeDTO edto1=new EmployeeDTO();
		edto1.setEmployeeName("B");
		
		
		Map<CourseDTO,EmployeeDTO> map=new HashMap<CourseDTO,EmployeeDTO>();
		
		map.put(dto, edto);
		map.put(dto1, edto1);
		
		    for (Object ob :map.keySet()) {

                  CourseDTO c=(CourseDTO)ob;
                  System.out.println(c.getCourseName());
		    }
		
		
		
		
		
		
	}
	
	
}
