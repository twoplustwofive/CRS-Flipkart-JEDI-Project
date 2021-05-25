/**
 * 
 */
package com.flipkart.service;

import java.util.List;
import com.flipkart.exception.*;


import com.flipkart.bean.*;

/**
 * @author Aditya
 *
 */
public interface AdminInterface 
{
	
	public List<Course> viewCourses(int catalogId);
	public List<Professor> viewProfessors();
	
	
	/**
	 * Method to generate grade card of a Student 
	 * studentid 
	 */
	public void generateGradeCard(int Studentid);
	
	/**
	 * Method to approve a Student 
	 * studentid
	 * studentlist
	 */
	
	public void approveStudent(int studentid, List<Student> studentlist) throws StudentNotFoundForApprovalException;
	
	/**
	 * Method to add Professor to DB
	 * professor : Professor Object storing details of a professor 
	 */
	
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;
	
	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseCode
	 * @param courseList : Courses available in the catalog
	 * @throws CourseNotFoundException 
	 * @throws CourseNotDeletedException 
	 */

	public void removeCourse(String coursecode, List<Course> courselist) throws CourseNotFoundException, CourseNotDeletedException;
	
	/**
	 * Method to add Course to Course Catalog
	 * @param course : Course object storing details of a course
	 * @param courseList : Courses available in the catalog
	 * @throws CourseExistsAlreadyException;
	 */
	
	public void addCourse(Course course, List<Course> courselist) throws CourseExistsAlreadyException;
	
	/**
	 * Method to assign Course to a Professor
	 * @param courseCode
	 * @param professorId
	 * @throws CourseNotFoundException 
	 * @throws UserNotFoundException 
	 */
	public void assignCourse(String courseCode, String professorId) throws CourseNotFoundException, UserNotFoundException;
	
}
