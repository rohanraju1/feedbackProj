package org.capG.feedBackProj.dto;

import java.io.Serializable;



public class FacultyDTO implements Serializable {

	private int facultyId;
	private String skills;
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	
	
}
