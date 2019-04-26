package org.capG.feedBackProj.dao;

import java.util.List;

import org.capG.feedBackProj.dto.EmployeeDTO;
import org.capG.feedBackProj.dto.FacultyDTO;


public interface DaoInf {
	
	public boolean saveFacultyDetails(FacultyDTO facultyDTO);

	public EmployeeDTO getEmployeeDetails(int FacultyId,String Ename);
	
	public EmployeeDTO getLoginData(int user_name,String pass_word);
	
	public EmployeeDTO viewFaculty(int FacultyId);
	
	public List<EmployeeDTO> viewFacultyAll();
	
	public boolean updateFacultyDetails(FacultyDTO facultyDTO);
	/*
	 
	public boolean addCourse();
	public List<CourseDTO> viewCourses();
	public boolean updateCourse();
	
   public boolean addParticipant();
	
   public List<ParticipantDTO> getParticipantDetails();
   
   public boolean deleteParticipantDetails();
   
   public boolean updateParticipant();
   
   public boolean addFeedBack();
   
   public boolean addTrainingPrgm();
   
   public boolean updateTrainingPrgm();
   
   public boolean deleteTrainingPrgm();
   
   public List<CourseDTO> viewPrgms();
   
   public List<FeedBackDTO> viewFeedBackReport();*/
   
   
}
