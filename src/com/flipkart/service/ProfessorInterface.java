/**
 * 
 */
package com.flipkart.service;

import java.util.List;


import com.flipkart.bean.*;
/**
 * @author vivek
 *
 */
public interface ProfessorInterface {
	
	public boolean addGrade(String studentID, String courseID, String grade);
	
	//type must be RegisteredCourse
	public List<RegisteredCourse> viewEnrolledStudent(String courseID);
	
	//type must be Course
	public List<Course> getCourses(String profID);
}
