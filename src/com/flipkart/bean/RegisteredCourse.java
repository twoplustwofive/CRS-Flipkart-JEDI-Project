/**
 * 
 */
package com.flipkart.bean;


/*
 * @author Aditya
 *
 */

import com.flipkart.constant.Grade;

public class RegisteredCourse 
{
	Course course;
	String studentId;
	Grade grade;
	
	
	
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
		this.course = new Course(course.getCourseCode(), course.getCourseName(), course.getInstructorId() ,course.getSeats());
	}
	
	
	/**
	 * @return the studentId
	 */
	public String getstudentId() {
		return studentId;
	}
	
	
	/**
	 * @param studentId the studentId to set
	 */
	public void setstudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	/**
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}
	
	
	
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = Grade.valueOf(grade);
	}
	
	
	
	

}
