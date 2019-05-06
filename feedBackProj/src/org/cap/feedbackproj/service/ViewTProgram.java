package org.cap.feedbackproj.service;

import java.util.List;

import org.cap.feedbackproj.dao.DaoImpl;
import org.cap.feedbackproj.dao.DaoInf;
import org.cap.feedbackproj.dto.TrainingProgramDTO;

public class ViewTProgram {

	/*Return Programs List Object From DAO*/
	public static List<TrainingProgramDTO> getPrograms() {


		DaoInf viewPrograms=new DaoImpl();
		List<TrainingProgramDTO> pList=null;
		try {
			pList=viewPrograms.viewPrgms(); //Access DataBase with the help of DAO to return all Training Programs Data
		} catch (Exception e) {
              e.printStackTrace();
		 }
		return pList;
	}

}
