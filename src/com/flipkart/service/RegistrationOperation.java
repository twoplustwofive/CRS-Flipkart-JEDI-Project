package com.flipkart.service;

import java.sql.SQLException;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Notification;
import com.flipkart.bean.Grade;
<<<<<<< HEAD
import com.flipkart.constant.PaymentMode;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
import com.flipkart.exception.CourseLimitExceededException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.SeatNotAvailableException;
import com.flipkart.validator.StudentValidator;
=======
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb

/**
 * @author Aditya
 * The Registration Operation provides the business logic for student registration.
 * 
 */
<<<<<<< HEAD
public class RegistrationOperation implements RegistrationInterface {

	private static volatile RegistrationOperation instance = null;

	private RegistrationOperation() {
=======
public class RegistrationOperation implements RegistrationInterface 
{
	
	private static volatile RegistrationOperation instance = null;

	private RegistrationOperation() {
	}

	/**
	 * Method to make Registration Operation Singleton
	 * 
	 * @return
	 */
	public static RegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (RegistrationOperation.class) {
				instance = new RegistrationOperation();
			}
		}
		return instance;
	}

	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperation.getInstance();

	@Override
	public boolean addCourse(String crsCode, String studentID, List<Course> courseCart) 
	{
		Course crs = new Course();
		
		/*
		 * Fetch from the DATABASE
		 * 
		 * */
		
		
		courseCart.add(crs);
		
		return true;
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	}

	/**
	 * Method to make Registration Operation Singleton
	 * 
	 * @return
	 */
	public static RegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (RegistrationOperation.class) {
				instance = new RegistrationOperation();
			}
		}
		return instance;
	}

	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperation.getInstance();

	/**
	 * Method to add Course selected by student 
	 * @param courseCode
	 * @param studentId
	 * @param courseList 
	 * @return boolean indicating if the course is added successfully
	 * @throws CourseNotFoundException
	 * @throws SeatNotAvailableException 
	 * @throws CourseLimitExceedException 
	 * @throws SQLException 
	 */
	@Override
<<<<<<< HEAD
	public boolean addCourse(String courseCode, int studentId,List<Course> availableCourseList) throws CourseNotFoundException, CourseLimitExceededException, SeatNotAvailableException, SQLException 
=======
	public boolean dropCourse(String crsCode, String studentID, List<Course> courseCart) throws CourseNotFoundException
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	{
       
		

		if (registrationDaoInterface.numOfRegisteredCourses(studentId) >= 6)
		{	
			throw new CourseLimitExceededException(6);
		}
		else if (registrationDaoInterface.isRegistered(courseCode, studentId)) 
		{
			return false;
		} 
		else if (!registrationDaoInterface.seatAvailable(courseCode)) 
		{
			throw new SeatNotAvailableException(courseCode);
		} 
		else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList))
		{
			throw new CourseNotFoundException(courseCode);
		}
		
		  

		return registrationDaoInterface.addCourse(courseCode, studentId);

	}

	/**
	 *  Method to drop Course selected by student
	 * @param courseCode
	 * @param studentId
	 * @param registeredCourseList 
	 * @return boolean indicating if the course is dropped successfully
	 * @throws CourseNotFoundException
	 * @throws SQLException 
	 */
	@Override
<<<<<<< HEAD
	public boolean dropCourse(String courseCode, int studentId,List<Course> registeredCourseList) throws CourseNotFoundException, SQLException {
		  if(!StudentValidator.isRegistered(courseCode, studentId, registeredCourseList))
	        {
	        	throw new CourseNotFoundException(courseCode);
	        }
		
		return registrationDaoInterface.dropCourse(courseCode, studentId);

=======
	public List<Course> viewCourses(String studentID) 
	{
		// TODO Auto-generated method stub
		return null;
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	}

	/** Method for Fee Calculation for selected courses
	 * Fee calculation for selected courses
	 * @param studentId
	 * @return Fee Student has to pay
	 * @throws SQLException 
	 */
	@Override
<<<<<<< HEAD
	public double calculateFee(String studentId) throws SQLException {
		return registrationDaoInterface.calculateFee(studentId);
=======
	public List<Course> viewRegisteredCourses(String studentID) 
	{
		// TODO Auto-generated method stub
		return null;
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	}


	/**
	 * Method to view grade card for students
	 * @param studentId
	 * @return List of Student's Grades
	 * @throws SQLException 
	 */
	@Override
<<<<<<< HEAD
	public List<Grade> viewGradeCard(String studentId) throws SQLException {
		return registrationDaoInterface.viewGradeCard(studentId);
=======
	public List<Grade> viewGradeCard(String studentID) 
	{
		// TODO Auto-generated method stub
		return null;
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	}

	/**
	 *  Method to view the list of available courses
	 * @param studentId
	 * @return List of courses
	 * @throws SQLException 
	 */
	
	@Override
<<<<<<< HEAD
	public List<Course> viewCourses(String studentId) throws SQLException {
		return registrationDaoInterface.viewCourses(studentId);
=======
	public double calculateFee(String studentID) {
		// TODO Auto-generated method stub
		return 0;
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	}

	/**
	 * Method to view the list of courses registered by the student
	 * @param studentId
	 * @return List of courses
	 * @throws SQLException 
	 */
	@Override
<<<<<<< HEAD
	public List<Course> viewRegisteredCourses(String studentId) throws SQLException {
		return registrationDaoInterface.viewRegisteredCourses(studentId);
=======
	public boolean getRegistrationStatus(String studentID) {
		// TODO Auto-generated method stub
		return false;
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	}
    
	/**
	 *  Method to check student registration status
	 * @param studentId
	 * @return boolean indicating if the student's registration status
	 * @throws SQLException
	 */
	@Override
<<<<<<< HEAD
	public boolean getRegistrationStatus(String studentId) throws SQLException {
		return registrationDaoInterface.getRegistrationStatus(studentId);
	}
	
	/**
	 * Method to set student registration status
	 * @param studentId
	 * @throws SQLException
	 */
	@Override
	public void setRegistrationStatus(String studentId) throws SQLException {
		registrationDaoInterface.setRegistrationStatus(studentId);

=======
	public void setRegistrationStatus(String studentID) {
		// TODO Auto-generated method stub
		
>>>>>>> 272dedbcac3432355690e38bc23c15bb75a871fb
	}

}