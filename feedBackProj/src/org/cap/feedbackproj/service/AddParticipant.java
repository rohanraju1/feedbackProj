package org.cap.feedbackproj.service;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.ParticipantDTO;

public class AddParticipant {

	public static boolean saveParticipant(int trainingCode, int participantCode, String participantName,
			String courseName)
	{

		boolean addParticipantStatus=false;
		
		ParticipantDTO addPartipantDTO=new ParticipantDTO();
		
		addPartipantDTO.setTrainingCode(trainingCode);
		addPartipantDTO.setParticipantCode(participantCode);
		addPartipantDTO.setParticipantName(participantName);
		addPartipantDTO.setCourseName(courseName);
		
		   DaoInf add=new DaoImpl();
		
		addParticipantStatus=add.addParticipant(addPartipantDTO);
		
		return addParticipantStatus;
	}

}
