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
	
	public List<RegisteredCourse> viewEnrolledStudent(String courseID);
	
	public List<Course> getCourses(String profID);
}
