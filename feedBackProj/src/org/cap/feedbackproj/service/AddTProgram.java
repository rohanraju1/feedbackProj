package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.TrainingProgramDTO;

public class AddTProgram {

	
	public static boolean addProgram(TrainingProgramDTO tDTO)
	{
		boolean addPrgStat=false;
		
		DaoInf addPrg=new DaoImpl();
		
		addPrgStat=addPrg.addTrainingPrgm(tDTO); 
		
		return addPrgStat;
	}
	
	
}
