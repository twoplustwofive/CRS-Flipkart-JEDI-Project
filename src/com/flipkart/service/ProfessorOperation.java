/**
 * 
 */
package com.flipkart.service;

import java.util.List;

/**
 * @author Goenka
 *
 */
public class ProfessorOperation implements ProfessorInterface {

	@Override
	public boolean addGrade(String studentID, String courseID, String grade) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	//the type should be RegisteredCourse
	public List<String> viewEnrolledStudent(String courseID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//the type should be Course
	public List<String> getCourses(String profID) {
		// TODO Auto-generated method stub
		return null;
	}

}
