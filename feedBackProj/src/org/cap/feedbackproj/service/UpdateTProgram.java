package org.cap.feedbackproj.service;

import java.sql.Date;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.TrainingProgramDTO;


public class UpdateTProgram {

	public static boolean updatePrgm(int trainingCode, String facultyName, Date endDate) {

		boolean uStatus=false;
		
		DaoInf updatePrg=new DaoImpl();
		
		TrainingProgramDTO tDto=new TrainingProgramDTO();
		
		tDto.setTrainingCode(trainingCode);
		tDto.setFacultyName(facultyName);
		tDto.seteDate(endDate);
		
		uStatus=updatePrg.updateTrainingPrgm(tDto);
		
		return uStatus;
	}

}
