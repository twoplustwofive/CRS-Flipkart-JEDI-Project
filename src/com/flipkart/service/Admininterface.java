/**
 * 
 */
package com.flipkart.service;

/**
 * @author Aditya
 *
 */
public interface Admininterface 
{
	
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
	
	public void verifyStudent(int studentid, List<Student> studentlist);
	
	/**
	 * Method to add Professor to DB
	 * professor : Professor Object storing details of a professor 
	 */
	
	public void addProfessor(Professor professor);
	
	/**
	 * Method to Remove Course from Course Catalog
	 * coursecode
	 * courselist : Courses available in the catalog
	 */

	public void removeCourse(String coursecode, List<Course> courselist);
	
	/**
	 * Method to add Course to Course Catalog
	 * course : Course object storing details of a course
	 * courselist : Courses available in the catalog
	 */
	
	public void addCourse(Course course, List<Course> courselist);
}
