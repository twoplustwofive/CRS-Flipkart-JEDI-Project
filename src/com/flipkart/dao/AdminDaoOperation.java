/**
 * 
 */
package com.flipkart.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseExistsAlreadyException;
import com.flipkart.exception.CourseNotDeletedException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.UserIdAlreadyInUseException;
import com.flipkart.exception.UserNotFoundException;

/**
 * @author Tanishq
 *
 */


public class AdminDaoOperation implements AdminDaoInterface{
	
	private static volatile AdminDaoOperation instance = null;
	//private static Logger logger = Logger.getLogger(AdminDaoOperation.class);
	private PreparedStatement statement = null;
	
	/**
	 * Default Constructor
	 */
	private AdminDaoOperation(){}
	
	/**
	 * Method to make AdminDaoOperation Singleton
	 * @return
	 */
	public static AdminDaoOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminDaoOperation.class){
				instance = new AdminDaoOperation();
			}
		}
		return instance;
	}
	
	public List<Course> viewCourses()
	{
		
	}
	public List<Professor> viewProfessors()
	{
		
	}
	
	
	/**
	 * Method to generate grade card of a Student 
	 * studentid 
	 */
	public void generateGradeCard(int Studentid)
	{
		
	}
	
	/**
	 * Method to approve a Student 
	 * studentid
	 * studentlist
	 */
	
	public void verifyStudent(int studentid, List<Student> studentlist)
	{
		
	}
	
	/**
	 * Method to add Professor to DB
	 * professor : Professor Object storing details of a professor 
	 */
	
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException
	{
		
	}
	
	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseCode
	 * @param courseList : Courses available in the catalog
	 * @throws CourseNotFoundException 
	 * @throws CourseNotDeletedException 
	 */

	public void removeCourse(String coursecode, List<Course> courselist) throws CourseNotFoundException, CourseNotDeletedException
	{
		
	}
	
	/**
	 * Method to add Course to Course Catalog
	 * @param course : Course object storing details of a course
	 * @param courseList : Courses available in the catalog
	 * @throws CourseExistsAlreadyException;
	 */
	
	public void addCourse(Course course, List<Course> courselist) throws CourseExistsAlreadyException
	{
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			
			statement.setInt(3, 1);
			int row = statement.executeUpdate();
			
			logger.info(row + " course added");
			if(row == 0) {
				logger.error("Course with courseCode: " + course.getCourseCode() + "not added to catalog.");
				throw new CourseFoundException(course.getCourseCode());
			}
			
			logger.info("Course with courseCode: " + course.getCourseCode() + " is added to catalog."); 
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			throw new CourseFoundException(course.getCourseCode());
			
		}
		
	}
	
	/**
	 * Method to assign Course to a Professor
	 * @param courseCode
	 * @param professorId
	 * @throws CourseNotFoundException 
	 * @throws UserNotFoundException 
	 */
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException
	{
		
	}
	

}
