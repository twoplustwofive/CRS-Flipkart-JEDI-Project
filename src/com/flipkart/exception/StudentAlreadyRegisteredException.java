/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Tanishq
 *
 */
public class StudentAlreadyRegisteredException extends Exception{
	
	private String StudentId;
	
	public StudentAlreadyRegisteredException(String id) {
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
		return "StudentId: " + StudentId + " not registered!";
	}
}
