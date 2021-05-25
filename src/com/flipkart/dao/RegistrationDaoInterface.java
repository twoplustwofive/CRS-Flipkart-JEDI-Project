package com.flipkart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.GradeCard;

/**
 * @author vijayrathod
 * Interface for Registration DAO Operation
 */


public interface RegistrationDaoInterface {

	/**
	 * Method to add course in database
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is added successfully
	 */
	public boolean addCourse(String courseCode, int studentId) throws SQLException;

	
	/**
	 * Drop Course selected by student
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is dropped successfully
	 */
	
	public boolean dropCourse(String courseCode, int studentId) throws SQLException;

	/**
	 * Method to get the list of courses available from course catalog 
	 * @param studentId
	 * @return list of Courses
	 */
	public List<Course> viewCourses(int studentId) throws SQLException;

	
	/**
	 * Method to View list of Registered Courses
	 * @param studentId
	 * @return list of Registered Courses
	 */
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException;

	
	/**
	 * Method to view grade card of the student
	 * @param studentId
	 * @return Grade Card
	 */
	public List<GradeCard> viewGradeCard(int studentId) throws SQLException;

	/**
	 * Method to retrieve fee for the selected courses from the database and calculate total fee
	 * @param studentId
	 * @return Fee Student has to pay
	 */
	public double calculateFee(int studentId) throws SQLException;

	/**
	 * Check if seat is available for that particular course
	 * @param courseCode
	 * @return seat availability status
	 */
	public boolean seatAvailable(String courseCode) throws SQLException;

	/**
	 * Method to get the list of courses registered by the student
	 * Number of registered courses for a student
	 * @param studentId
	 * @return Number of registered Courses
	 */
	public int numOfRegisteredCourses(int studentId) throws SQLException;

	/**
	 * Method checks if the student is registered for that course
	 * @param courseCode
	 * @param studentId
	 * @return Students registration status
	 */
	public boolean isRegistered(String courseCode, int studentId) throws SQLException;

	
	/**
	 *  Method to get student registration status
	 * @param studentId
	 * @return Student's registration status
	 */
	public boolean getRegistrationStatus(int studentId) throws SQLException;

	/**
	 *  Method to set student registration status
	 * @param studentId
	 */
	public void setRegistrationStatus(int studentId) throws SQLException;

	
}
