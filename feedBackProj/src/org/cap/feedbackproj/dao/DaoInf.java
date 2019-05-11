package org.cap.feedbackproj.dao;

import java.util.List;
import java.util.Map;

import org.cap.feedbackproj.dto.CourseDTO;
import org.cap.feedbackproj.dto.EmployeeDTO;
import org.cap.feedbackproj.dto.FacultyDTO;
import org.cap.feedbackproj.dto.FeedBackDTO;
import org.cap.feedbackproj.dto.ParticipantDTO;
import org.cap.feedbackproj.dto.TrainingProgramDTO;


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

	public boolean addTrainingPrgm(TrainingProgramDTO addProgramDTO);

	public boolean updateTrainingPrgm(TrainingProgramDTO upProgramDTO);

	public boolean deleteTrainingPrgm(int trainingCode);

	public List<TrainingProgramDTO> viewPrgms();

	public boolean addParticipant(ParticipantDTO addPartipantDTO);

	public List<ParticipantDTO> getParticipantDetails();

	public boolean deleteParticipantDetails(ParticipantDTO delParticipantDTO);

    public Map<CourseDTO,EmployeeDTO> getViewAddFeedBack();

    public boolean addFeedBack(FeedBackDTO feedBackDTO);
	/*
   
   public List<FeedBackDTO> viewFeedBackReport();*/


}
