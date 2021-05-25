/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Aditya
 *
 */
public class RegisteredCourse 
{
	Course course;
	int stdID;
	String grade;
	int sem;
	
	
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	
	
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = new Course();
	}
	
	
	/**
	 * @return the stdID
	 */
	public int getStdID() {
		return stdID;
	}
	
	
	/**
	 * @param stdID the stdID to set
	 */
	public void setStdID(int stdID) {
		this.stdID = stdID;
	}
	
	
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	
	
	
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	/**
	 * @return the sem
	 */
	public int getSem() 
	{
		return sem;
	}
	
	
	/**
	 * @param sem the sem to set
	 */
	public void setSem(int sem) 
	{
		this.sem = sem;
	}
	
	
	
	
}
