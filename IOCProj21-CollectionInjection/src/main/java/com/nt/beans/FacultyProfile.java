package com.nt.beans;

import java.util.Date;
import java.util.Map;

public class FacultyProfile {
	private Map<String,String>  facultySubjects;
	private  Map<String,Date>   impDates;
	
	public FacultyProfile() {
		System.out.println("FacultyProfile: 0-param constructor");
	}
	
	public void setFacultySubjects(Map<String, String> facultySubjects) {
		System.out.println("FacultyProfile.setFacultySubjects()");
		this.facultySubjects = facultySubjects;
	}
	public void setImpDates(Map<String, Date> impDates) {
		System.out.println("FacultyProfile.setImpDates()");
		this.impDates = impDates;
	}

	@Override
	public String toString() {
		return "FacultyProfile [facultySubjects=" + facultySubjects + ", impDates=" + impDates + "]";
	}
	
	

}
