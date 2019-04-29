package org.cap.feedbackproj.dao;

import java.util.List;

import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.dto.EmployeeDTO;
import org.cap.feedbackproj.dto.FacultyDTO;


public interface DaoInf {
	
	public boolean saveFacultyDetails(FacultyDTO facultyDTO);

	public EmployeeDTO getEmployeeDetails(int FacultyId,String Ename);
	
	public EmployeeDTO getLoginData(int user_name,String pass_word);
	
	public EmployeeDTO viewFaculty(int FacultyId);
	
	public List<EmployeeDTO> viewFacultyAll();
	
	public boolean updateFacultyDetails(FacultyDTO facultyDTO);
	
	public boolean addCourse(CourseDTO addCourseDTO);
	
	public List<CourseDTO> viewCourses();
	
	public boolean updateCourse(CourseDTO updateCourseDTO);
	
	
	
	
	
	
	
	/*
	   public boolean addParticipant();
	
   public List<ParticipantDTO> getParticipantDetails();
   
   public boolean deleteParticipantDetails();
   
   public boolean updateParticipant();
   
   public boolean addFeedBack();
   
   public boolean addTrainingPrgm();
   ;
   public boolean updateTrainingPrgm();
   
   public boolean deleteTrainingPrgm();
   
   public List<CourseDTO> viewPrgms();
   
   public List<FeedBackDTO> viewFeedBackReport();*/
   
   
}
