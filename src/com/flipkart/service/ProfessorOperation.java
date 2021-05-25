/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;

/**
 * @author Goenka
 *
 */
public class ProfessorOperation implements ProfessorInterface {

	@Override
	public boolean addGrade(String studentID, String courseID, String grade) 
	{
		// 
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
	public List<String> viewCourses(String profID) 
	{
		return null;
	}

}
