package com.flipkart.exceptions;

/**
 * Exception to check if the professor is not added successfully by admin
 * @author Tribhav Chaudhary
 *
 */
public class StudentNotRegisteredException extends Exception{
	private String StudentId;
	
	public StudentNotRegisteredException(String id) {
		StudentId = id;
	}
	
	/**
	 * Getter function for professorId
	 * @return
	 */
	public String getUserId() {
		return StudentId;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "professorId: " + StudentId + " not registered!";
	}
}