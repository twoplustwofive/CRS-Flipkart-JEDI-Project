/**
 * 
 */
package com.flipkart.service;

/**
 * @author vivek
 *
 */
public interface ProfessorInterface {
	
	public boolean addGrade(String studentID, String courseID, String grade);
	
	public List<RegisteredCourse> viewEnrolledStudent(String courseID);
	
	public List<Course> getCourses(String profID);
}
