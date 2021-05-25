/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Tanishq
 *
 */
public class StudentAlreadyRegisteredException extends Exception{
	
	private int StudentId;
	
	public StudentAlreadyRegisteredException(int id) {
		StudentId = id;
	}
	
	/**
	 * Getter function for professorId
	 * @return
	 */
	public int getUserId() {
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
