package org.cap.feedbackproj.service;

import java.util.List;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.ParticipantDTO;

public class ViewParticipant {

	/*Return List Object From DAO*/
	public static List<ParticipantDTO> getParticipant() {

		DaoInf participantList=new DaoImpl();
		List<ParticipantDTO> pList=null;
		
		try {
			pList=participantList.getParticipantDetails(); //Access DataBase with the help of DAO to return all Participant Data
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pList;
	}

}
