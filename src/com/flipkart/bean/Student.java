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
	
	//Constructing User of a Student type.
	public Student(int userID, String name, Gender gender, Role role, String password, String address) 
	{
		super(userID, name, gender, role, password, address);
	}


	private String department;
	private int stdID;
	private int gradYear;
	
	
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
	 * @return the stdID
	 */
	public int getStdID() 
	{
		return stdID;
	}
	
	
	/**
	 * @param stdID the stdID to set
	 */
	public void setStdID(int stdID) 
	{
		this.stdID = stdID;
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
