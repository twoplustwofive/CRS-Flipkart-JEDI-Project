/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade; 

/**
 * @author Aditya
 *
 */
public interface RegistrationInterface 
{
	public boolean addCourse(String crsCode, int stdID, List<Course> courseList);
	
	public boolean dropCourse(String crsCode, int stdId, List<Course> registeredCrsList);
	
	public List<Course> viewCourses(int stdId);
	
	public List<Course> viewRegisteredCourses(int stdId);
	
	public List<Grade> viewGradeCard(int stdId);
	
	public double calculateFee(int stdId);
	
	public boolean getRegistrationStatus(int stdId);
	
	public void setRegistrationStatus(int stdId);
}
