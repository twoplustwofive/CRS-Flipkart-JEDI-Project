/**
 * 
 */
package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException; 

/**
 * @author Aditya
 *
 */
public interface RegistrationInterface 
{
	public boolean addCourse(String crsCode, int stdID, List<Course> courseList) throws CourseNotFoundException, CourseLimitExceededException, SeatNotAvailableException, SQLException;
	
	public boolean dropCourse(String crsCode, int studentId, List<Course> registeredCrsList) throws CourseNotFoundException, SQLException;
	
	public List<Course> viewCourses(String studentId) throws SQLException;
	
	public List<Course> viewRegisteredCourses(String studentId) throws SQLException;
	
	public List<Grade> viewGradeCard(String studentId) throws SQLException;
	
	public double calculateFee(String studentId) throws SQLException;
	
	public boolean getRegistrationStatus(String studentId) throws SQLException;
	
	public void setRegistrationStatus(String studentId) throws SQLException;
}
