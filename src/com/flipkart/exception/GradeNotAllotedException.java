/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Tanishq
 *
 */
public class GradeNotAllotedException extends Exception{
	 
	private int studentId;
	 
	/**
	 * Constructor
	 * @param studentId
	 */
	 public GradeNotAllotedException(int studentId)
	 {
		 this.studentId=studentId;
	 }
	 
	 /**
	  * Getter function for studentId
	  * @return
	  */
	 public int getStudentId()
	 {
		 return studentId;
	 }
	 
	 /**
		 * Message returned when exception is thrown
	 */
	 
	 public String getMessage() 
	 {
			return "Student with id: " + studentId + "hasn't been alloted a grade yet";
	 }
}
