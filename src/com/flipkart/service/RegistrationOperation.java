/**
 * 
 */
package com.flipkart.service;

import java.util.List;

import com.flipkart.exception.*;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grade;
import com.flipkart.dao.RegistrationDaoInterface;
import com.flipkart.dao.RegistrationDaoOperation;

/**
 * @author Aditya
 *
 */
public class RegistrationOperation implements RegistrationInterface 
{
	
	private static volatile RegistrationOperation instance = null;

	private RegistrationOperation() {
	}

	/**
	 * Method to make Registration Operation Singleton
	 * 
	 * @return
	 */
	public static RegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (RegistrationOperation.class) {
				instance = new RegistrationOperation();
			}
		}
		return instance;
	}

	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperation.getInstance();

	@Override
	public boolean addCourse(String crsCode, String studentID, List<Course> courseCart) 
	{
		Course crs = new Course();
		
		/*
		 * Fetch from the DATABASE
		 * 
		 * */
		
		
		courseCart.add(crs);
		
		return true;
	}

	@Override
	public boolean dropCourse(String crsCode, String studentID, List<Course> courseCart) throws CourseNotFoundException
	{
		
		try
		{	
			for(Course i : courseCart)
			{ 
				if(i.getCourseCode() == crsCode)
					courseCart.remove(i);
			}
		}
		
		catch(CourseNotFoundException e)
		{
			throw e;
		}
		
		
		return false;
	}

	@Override
	public List<Course> viewCourses(String studentID) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> viewRegisteredCourses(String studentID) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grade> viewGradeCard(String studentID) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateFee(String studentID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRegistrationStatus(String studentID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRegistrationStatus(String studentID) {
		// TODO Auto-generated method stub
		
	}

}
