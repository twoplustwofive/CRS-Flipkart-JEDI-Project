/**
 * 
 */
package com.flipkart.service;

import com.flipkart.exception.*;

import java.util.List;

import com.flipkart.bean.*;

/**
 * @author Tanishq
 *
 */

public class AdminOperation implements AdminInterface{
	
	
	/**
	 * Method to generate grade card of a Student 
	 * studentid 
	 */
	public List<Course> viewCourses()
	{
		return null;
	}
	public List<Professor> viewProfessors()
	{
		return null;
	}
	
	public void generateGradeCard(int Studentid)
	{
		
	}
	
	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseCode
	 * @param courseList : Courses available in the catalog
	 * @throws CourseNotFoundException 
	 */
	@Override
	public void removeCourse(String dropCourseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException {
		
	}

	/**
	 * Method to add Course to Course Catalog
	 * @param course : Course object storing details of a course
	 * @param courseList : Courses available in catalog
	 * @throws CourseFoundException
	 */
	@Override
	public void addCourse(Course newCourse, List<Course> courseList) throws CourseExistsAlreadyException {
		
	}
	
	/**
	 * Method to approve a Student 
	 * @param studentId
	 * @param studentList 
	 * @throws StudentNotFoundException 
	 */
	@Override
	public void verifyStudent(int studentId, List<Student> studentList) {
		
	}

	/**
	 * @param professor : Professor Object storing details of a professor
	 * @throws ProfessorNotAddedException
	 */
	@Override
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException {
		
		
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
