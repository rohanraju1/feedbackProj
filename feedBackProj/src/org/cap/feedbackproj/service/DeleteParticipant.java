package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.ParticipantDTO;

public class DeleteParticipant {

	/*This method will return boolean value whether value is Deleted with the help of DAO*/
	public static boolean delParticipant(int trainingCode, int participantCode, String participantName) 
	{
		boolean delStat=false;
		
		DaoInf deleteParticpant=new DaoImpl();
		
		ParticipantDTO participantDTO=new ParticipantDTO();
		participantDTO.setTrainingCode(trainingCode);
		participantDTO.setParticipantCode(participantCode);
        participantDTO.setParticipantName(participantName);
        
		delStat=deleteParticpant.deleteParticipantDetails(participantDTO); //Access DataBase to delete Participant with DAO
		
		return delStat;
	}
	
	
}
