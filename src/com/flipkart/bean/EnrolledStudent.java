/**
 * 
 */
package com.flipkart.bean;

/**
 * @author Aditya
 *
 */
public class EnrolledStudent extends Student
{
	private String crsCode;
	private String crsName;
	
	/**
	 * @return the crsCode
	 */
	public String getCrsCode() 
	{
		return crsCode;
	}
	
	
	/**
	 * @param crsCode the crsCode to set
	 */
	public void setCrsCode(String crsCode) 
	{
		this.crsCode = crsCode;
	}
	
	/**
	 * @return the crsName
	 */
	public String getCrsName() 
	{
		return crsName;
	}
	
	
	/**
	 * @param crsName the crsName to set
	 */
	public void setCrsName(String crsName) 
	{
		this.crsName = crsName;
	}
	
}
