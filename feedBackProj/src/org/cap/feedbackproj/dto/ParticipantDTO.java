package org.cap.feedbackproj.dto;

public class ParticipantDTO {
     
	private int trainingCode;
	private int participantCode;
	private String participantName;
	private String courseName;
	
	public int getTrainingCode() {
		return trainingCode;
	}
	public void setTrainingCode(int trainingCode) {
		this.trainingCode = trainingCode;
	}
	public int getParticipantCode() {
		return participantCode;
	}
	public void setParticipantCode(int participantCode) {
		this.participantCode = participantCode;
	}
	public String getParticipantName() {
		return participantName;
	}
	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
}
