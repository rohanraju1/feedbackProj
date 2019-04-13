package org.capG.feedBackProj.dto;

import java.io.Serializable;



public class FacultyDTO implements Serializable {

	private int facultyId;
	private String Skills;
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		Skills = skills;
	}
	
	
	
}
