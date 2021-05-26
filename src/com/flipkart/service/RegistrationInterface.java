/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.exception.CourseNotFoundException; 

/**
 * @author Aditya
 *
 */
public interface RegistrationInterface 
{
	public boolean addCourse(String crsCode, String studentID, List<Course> courseList);
	
	public boolean dropCourse(String crsCode, String studentId, List<Course> registeredCrsList) throws CourseNotFoundException;
	
	public List<Course> viewCourses(String studentID);
	
	public List<Course> viewRegisteredCourses(String studentID);
	
	public List<Grade> viewGradeCard(String studentID);
	
	public double calculateFee(String studentID);
	
	public boolean getRegistrationStatus(String studentID);
	
	public void setRegistrationStatus(String studentID);
}
