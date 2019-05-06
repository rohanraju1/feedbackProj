package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;

public class DeleteTProgram {

	public static boolean deletePrgm(int trainingCode)
	{
		boolean delStatus=false;
		
		DaoInf delete=new DaoImpl();
		
		delStatus=delete.deleteTrainingPrgm(trainingCode);
		
		return delStatus;
	}
	
}
