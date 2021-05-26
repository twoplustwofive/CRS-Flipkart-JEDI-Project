/**
 * 
 */
package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

/**
 * @author Aditya
 *
 */
public class Student extends User 
{
	private String department;
	private String studentId;
	private int gradYear;
	boolean isApproved;
	
	//Constructing User of a Student type.
	public Student(String userID, String name, Gender gender, Role role, String password, String address) 
	{
		super(userID, name, gender, role, password, address);
	}

	
	public Student(String userId, String name, Role student, String password, Gender gender, String address,
			String branch, int i, int batch, boolean b) 
	{
		super(userId, name, gender, student, password, address);
	}


	/**
	 * @return the department
	 */
	public String getDepartment() 
	{
		return department;
	}
	
	
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) 
	{
		this.department = department;
	}
	
	
	/**
	 * @return the studentID
	 */
	public String getStudentId() 
	{
		return studentId;
	}
	
	
	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) 
	{
		this.studentID = studentID;
	}
	
	
	/**
	 * @return the gradYear
	 */
	public int getGradYear() 
	{
		return gradYear;
	}
	
	
	/**
	 * @param gradYear the gradYear to set
	 */
	public void setGradYear(int gradYear) 
	{
		this.gradYear = gradYear;
	}
		
	
}
